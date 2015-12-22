package analyse;

import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by florian on 23.11.15.
 */
public class ImageExtractor implements Analyser<BufferedImage> {

    @Override
    public BufferedImage analyse(BufferedImage image, Rectangle rectangle) {
        LoggerFactory.getLogger("ocr_analyse").info("cutting: " + (int) rectangle.getX() + " " +
                (int) rectangle.getY() + " " +
                (int) (rectangle.getX() + rectangle.getWidth()) + " " +
                (int) (rectangle.getY() + rectangle.getHeight()));

        return image.getSubimage((int) rectangle.getX(),
                (int) rectangle.getY(),
                (int) rectangle.getWidth(),
                (int) rectangle.getHeight());
    }

    @Override
    public void setValue(String val) {

    }
}
