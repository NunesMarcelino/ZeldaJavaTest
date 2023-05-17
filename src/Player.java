import java.awt.*;

public class Player extends Rectangle
{
    public boolean right, left, down, up;
    public int spd = 4;
    public void tick()
    {
        if(right && World.isFree(x+spd,y))
        {
            x+=spd;
        } else if (left && World.isFree(x-spd,y))
        {
            x-=spd;
        }

        if(up && World.isFree(x,y-spd))
        {
            y-=spd;
        } else if (down && World.isFree(x,y+spd))
        {
            y+=spd;
        }

    }

    public void render(Graphics g)
    {
        g.drawImage(Spritesheet.Player_front,x,y,32,32,null);
    }

    public Player(int x, int y)
    {
        super(x,y,32,32);
    }


}
