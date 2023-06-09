import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player extends Rectangle
{
    public boolean right, left, down, up, shoot = false;
    public int dir = 1, spd = 4;

    public static List<Bullet> Bullets = new ArrayList<Bullet>();
    public int curAnimation = 0, curFrames = 0, targetFrames = 15;

    public void tick()
    {
        boolean moved = false;
        if(right && World.isFree(x+spd,y))
        {
            dir = 1;
            moved = true;
            x+=spd;
        } else if (left && World.isFree(x-spd,y))
        {
            dir = -1;
            x-=spd;
            moved = true;
        }

        if(up && World.isFree(x,y-spd))
        {
            y-=spd;
            moved = true;
        } else if (down && World.isFree(x,y+spd))
        {
            y+=spd;
            moved = true;
        }

        if (shoot)
        {
            shoot = false;
            Bullets.add(new Bullet(x,y,dir));
        }

        for (int i = 0; i < Bullets.size(); i++)
        {
            Bullets.get(i).tick();
        }

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

    public Player(int x, int y)
    {
        super(x,y,32,32);
    }


}
