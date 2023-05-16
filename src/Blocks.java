import java.awt.*;

public class Blocks extends Rectangle
{
    public Blocks(int x, int y)
    {
        super(x,y,32,32);
    }

    public void render(Graphics g)
    {
        g.setColor(Color.magenta);
        g.fillRect(x,y,width,height);
        g.setColor(Color.black);
        g.drawRect(x,y,width,height);
    }
}
