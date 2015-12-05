package preprocessing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by florian on 23.11.15.
 */
public class RotatePreProcessor extends PreProcessor {

    public RotatePreProcessor(int ranking) {
        super(ranking);
    }

    @Override
    public BufferedImage process(BufferedImage image) {
        return image;
    }

    public static void main(String[] args){
        PreProcessor test = PreProcessingType.ROTATE;

        test.setValue(10.0);

        try {
            BufferedImage rc = test.process(ImageIO.read(new File("./src/main/resources/test_files/Wikipedia_Test_Artikel.PNG")));

            ImageIO.write(rc, "png", new File("./src/main/resources/test_files/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
