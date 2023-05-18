import java.awt.*;

public class Player extends Rectangle
{
    public boolean right, left, down, up;
    public int spd = 4;

    public int curAnimation = 0, curFrames = 0, targetFrames = 15;

    public void tick()
    {
        boolean moved = false;
        if(right && World.isFree(x+spd,y))
        {
            moved = true;
            x+=spd;
        } else if (left && World.isFree(x-spd,y))
        {
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
    }

    public Player(int x, int y)
    {
        super(x,y,32,32);
    }


}
