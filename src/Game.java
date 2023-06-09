import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class Game extends Canvas implements Runnable, KeyListener
{

    public static int WIDTH = 640, HEIGHT = 480;
    public static int SCALE = 3;

    public static Player player;
    public World world;
    public List<Enemy> Enemies = new ArrayList<Enemy>();

    public void tick()
    {
        player.tick();
        for (int i = 0; i < Enemies.size(); i++)
        {
            Enemies.get(i).tick();
        }
    }

    public void render()
    {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(new Color(0,135,0));
        g.fillRect(0,0, WIDTH*SCALE, HEIGHT*SCALE);

        player.render(g);

        for (int i = 0; i < Enemies.size(); i++)
        {
            Enemies.get(i).render(g);
        }

        world.render(g);


        bs.show();
    }

    public Game()
    {
        this.addKeyListener(this);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        new Spritesheet();

        player = new Player(32,32);
        world = new World();
        Enemies.add(new Enemy(82,64));
        Enemies.add(new Enemy(82,204));
    }

    public static void main(String[] args)
    {
        Game game = new Game();
        JFrame frame = new JFrame();
        frame.add(game);
        frame.setTitle("Zelda");
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        new Thread(game).start();
    }

    @Override
    public void run()
    {
        do
        {
            tick();
            render();
            try
            {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        } while (true);



    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            player.right = true;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            player.left = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            player.up = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            player.down = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_Z)
        {
            player.shoot = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            player.right = false;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            player.left = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            player.up = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            player.down = false;
        }
    }
}