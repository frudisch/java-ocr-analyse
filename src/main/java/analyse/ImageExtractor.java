package analyse;

import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * extrahiert ein durch ein rechteck definiertes bild aus einem bild
 * Created by florian on 23.11.15.
 */
public class ImageExtractor implements Analyser<BufferedImage> {

    /**
     * extrahiert den durch das übergebene rectangle definierte bereich aus dem bild und liefert ihn als bild zurück
     * @param image zu analysierendes Bild
     * @param rectangle zu analysierender Bereich
     * @return bildausschnitt
     */
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
