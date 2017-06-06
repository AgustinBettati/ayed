package main.testOfRedBlackAnd234Tree.tree234;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Jorge
 * Date: Jun 6, 2006
 * Time: 5:18:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class BufferedImageLoader {
    public static BufferedImage BufferedImageLoad(String url){
            BufferedImage layer;
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsConfiguration gc = ge.getDefaultScreenDevice().getDefaultConfiguration();
            try {
                BufferedImage im = ImageIO.read(BufferedImageLoader.class.getResource(url));
                int transparency = im.getColorModel().getTransparency();
                layer = gc.createCompatibleImage(im.getWidth(),im.getHeight(),transparency);

                Graphics2D g2 = layer.createGraphics();
                g2.drawImage(im,0,0,null);
                g2.dispose();
                return layer;
            }
            catch(IOException e) {
                System.out.println("Load Image error:");
            }
            return layer = null;
        }
}
