import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable
{

    public static int WIDTH = 480, HEIGHT = 480;

    public void tick()
    {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0, WIDTH, HEIGHT);

        g.setColor(Color.RED);
        g.fillRect(10, 10, 50, 50);
        bs.show();
    }

    public void render()
    {

    }

    public Game()
    {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
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
        while (true)
        {
            tick();
            render();
            try
            {
                Thread.sleep(1000/60);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }



    }
}
