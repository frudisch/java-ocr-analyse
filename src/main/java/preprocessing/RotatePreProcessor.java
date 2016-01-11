package preprocessing;

import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Benedikt Linke on 23.11.15.
 */
public class RotatePreProcessor extends PreProcessor {

    public RotatePreProcessor(int ranking) {
        super(ranking);
    }

    /**
     * rotiert das bild um den in der value angegeben wert und gibt es zurück
     * @param image zu verarbeitendes bild
     * @return verarbeitetes bild
     */
    @Override
    public BufferedImage process(BufferedImage image) {
        LoggerFactory.getLogger("ocr_analyse").info("rotating: " + getValue());

        double angle = getValue();
        double sin = Math.abs(Math.sin(Math.toRadians(angle)));
        double cos = Math.abs(Math.cos(Math.toRadians(angle)));

        int imgWidth = image.getWidth(null);
        int imgHeight = image.getHeight(null);
        int newWidth = (int) Math.floor(imgWidth * cos + imgHeight * sin);
        int newHeigth = (int) Math.floor(imgHeight * cos + imgWidth * sin);

        BufferedImage output = new BufferedImage(newWidth, newHeigth, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = output.createGraphics();
        g.translate((newWidth - imgWidth) / 2, (newHeigth - imgHeight) / 2);
        g.rotate(Math.toRadians(angle), imgWidth / 2, imgHeight / 2);
        g.drawRenderedImage(image, null);
        g.dispose();
        return output;
    }

    public static void main(String[] args){
        PreProcessor test = PreProcessingType.ROTATE;

        test.setValue(18.0);

        try {
            BufferedImage rc = test.process(ImageIO.read(new File("./src/main/resources/test_files/Wikipedia_Test_Artikel.PNG")));

            ImageIO.write(rc, "png", new File("./src/main/resources/test_files/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
