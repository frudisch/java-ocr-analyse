package preprocessing;

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

    @Override
    public BufferedImage process(BufferedImage img) {
        double angle = getValue();
        double sin = Math.abs(Math.sin(Math.toRadians(angle)));
        double cos = Math.abs(Math.cos(Math.toRadians(angle)));

        int imgWidth = img.getWidth(null);
        int imgHeight = img.getHeight(null);
        int newWidth = (int) Math.floor(imgWidth * cos + imgHeight * sin);
        int newHeigth = (int) Math.floor(imgHeight * cos + imgWidth * sin);

        BufferedImage newImage = new BufferedImage(newWidth, newHeigth, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.translate((newWidth - imgWidth) / 2, (newHeigth - imgHeight) / 2);
        g.rotate(Math.toRadians(angle), imgWidth / 2, imgHeight / 2);
        g.drawRenderedImage(img, null);
        g.dispose();
        return newImage;
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
