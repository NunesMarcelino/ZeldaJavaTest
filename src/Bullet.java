import java.awt.*;

public class Bullet extends Rectangle
{
    public int frames = 0, dir = 1;
    public int speed = 8;
    public Bullet(int x, int y, int dir)
    {
        super(x,y,10,10);
        this.dir = dir;

    }

    public void tick()
    {
        x+= speed * dir;
        frames++;
        if(frames == 60)
        {
            Player.Bullets.remove(this);
        }
    }

    public void render(Graphics g)
    {
        g.setColor(Color.yellow);
        g.fillOval(x+16,y+16,width,height);

    }
}
