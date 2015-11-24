package analyse;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by florian on 23.11.15.
 */
public interface Analyser {

    <T> T analyse(BufferedImage image, Rectangle rectangle);
}
