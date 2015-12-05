package analyse;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by florian on 23.11.15.
 */
public class ImageExtractor implements Analyser<BufferedImage> {

    @Override
    public BufferedImage analyse(BufferedImage image, Rectangle rectangle) {
        return image.getSubimage((int) rectangle.getX(),
                (int) rectangle.getY(),
                (int) (rectangle.getX() + rectangle.getWidth()),
                (int) (rectangle.getY() + rectangle.getHeight()));
    }
}
