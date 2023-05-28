import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy extends Rectangle
{
    public int right = 1, left = 0, down = 0, up = 0;
    public int dir = 1, spd = 2;

    public static List<Bullet> Bullets = new ArrayList<Bullet>();
    public int curAnimation = 0, curFrames = 0, targetFrames = 15;

    public void followPlayer()
    {

        Player p = Game.player;
         if (x < p.x && World.isFree(x+spd , y)){
             if (new Random().nextInt(100)<80)
             x+=spd;
         } else if (x > p.x && World.isFree(x-spd , y)){
             if (new Random().nextInt(100)<80)
             x-=spd;
         }

        if (y < p.y && World.isFree(x, y+spd)){
            if (new Random().nextInt(100)<50)
            y+=spd;
        } else if (y > p.y && World.isFree(x , y-spd)){
            if (new Random().nextInt(100)<50)
            y-=spd;
        }

    }

    public void tick()
    {
        boolean moved = false;


        followPlayer();




        if (moved)
        {
            curFrames++;
            if (curFrames == targetFrames)
            {
                curFrames = 0;
                curAnimation++;
                if (curAnimation == Spritesheet.enemy.length)
                {
                    curAnimation = 0;
                }
            }
        }

    }

    public void render(Graphics g)
    {
        g.drawImage(Spritesheet.enemy[curAnimation],x,y,32,32,null);
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
