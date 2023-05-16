import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class World
{

    public static List<Blocks> blocos = new ArrayList<>();

    public World()
    {
        for (int xx = 0; xx < 15; xx++) //up
        {
            blocos.add(new Blocks(xx*32,0));
        }

        for (int xx = 0; xx < 15; xx++) //right
        {
            blocos.add(new Blocks(xx*32,480-32));
        }

        for (int xx = 0; xx < 15; xx++) //down
        {
            blocos.add(new Blocks(0,xx*32));
        }

        for (int xx = 0; xx < 15; xx++) //left
        {
            blocos.add(new Blocks(480-32,xx*32));
        }

    }

    public static boolean isFree(int x, int y)
    {
        for (int i = 0; i < blocos.size(); i++)
        {
            Blocks blocoAtual = blocos.get(i);
            if(blocoAtual. intersects(new Rectangle(x,y,32,32)))
            {
                return false;
            }
        }
        return true;
    }


    public void render(Graphics g)
    {
        for (int i = 0; i < blocos.size(); i++)
        {
            blocos.get(i).render(g);
        }

    }
}
