import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Spritesheet
{


    public static BufferedImage [] Player_front;
    public static BufferedImage tileWall;
    public static BufferedImage spriteSheet;

    public Spritesheet()
    {
        try
        {
            spriteSheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        Player_front = new BufferedImage[2];

        Player_front[0] = Spritesheet.getSprite(0, 11, 16, 16);
        Player_front[1] = Spritesheet.getSprite(16, 11, 16, 16);
        tileWall = Spritesheet.getSprite(126, 224, 16, 16);

    }

    public static BufferedImage getSprite(int x, int y, int width, int height)
    {
        return spriteSheet.getSubimage(x, y, width, height);
    }
}
