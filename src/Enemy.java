import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Enemy extends Rectangle
{
    public int right, left, down, up;
    public int dir = 1, spd = 4;

    public static List<Bullet> Bullets = new ArrayList<Bullet>();
    public int curAnimation = 0, curFrames = 0, targetFrames = 15;

    public void tick()
    {
        boolean moved = false;





        if (moved)
        {
            curFrames++;
            if (curFrames == targetFrames)
            {
                curFrames = 0;
                curAnimation++;
                if (curAnimation == Spritesheet.Player_front.length)
                {
                    curAnimation = 0;
                }
            }
        }

    }

    public void render(Graphics g)
    {
        g.drawImage(Spritesheet.Player_front[curAnimation],x,y,32,32,null);
        for (int i = 0; i < Bullets.size(); i++)
        {
            Bullets.get(i).render(g);
        }
    }

    public Enemy(int x, int y)
    {
        super(x,y,32,32);
    }


}
