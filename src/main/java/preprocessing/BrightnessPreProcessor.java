package preprocessing;

import ij.ImagePlus;
import ij.process.ColorProcessor;
import ij.process.FloatProcessor;
import ij.process.ImageProcessor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

/**
 * Created by Benedikt Linke on 07.12.15.
 */
public class BrightnessPreProcessor extends PreProcessor {

    public BrightnessPreProcessor(int ranking) {
        super(ranking);
    }

    @Override
    public BufferedImage process(BufferedImage image) {

        double brightness = getValue()/100;
        float scalfactor = (float) (1.0f + brightness);
        System.out.println(scalfactor);
        RescaleOp rescaleOp = new RescaleOp(1.6f, 0, null); //decrease contrast
        rescaleOp.filter(image,image);

        return image;
    }



    public static void main(String[] args){
        PreProcessor test = PreProcessingType.INCREASE_BRIGHTNESS;

        test.setValue(-40.0);

        try {
            BufferedImage rc = test.process(ImageIO.read(new File("./src/main/resources/test_files/Wikipedia_Test_Artikel.PNG")));

            ImageIO.write(rc, "png", new File("./src/main/resources/test_files/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
