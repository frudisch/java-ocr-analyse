package preprocessing;

import ij.ImagePlus;
import ij.plugin.ContrastEnhancer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

/**
 * Created by Benedikt Linke on 23.11.15.
 */
public class ContrastPreProcessor extends PreProcessor {

    public ContrastPreProcessor(int ranking) {
        super(ranking);
    }

    @Override
    public BufferedImage process(BufferedImage image) {


        ImagePlus im = new ImagePlus("./src/main/resources/test_files/00 USA  ROADTRIP.png");
        ContrastEnhancer enh = new ContrastEnhancer();
        enh.stretchHistogram(im, getValue());
        return im.getBufferedImage();
    }



    public static void main(String[] args){
        PreProcessor test = PreProcessingType.INCREASE_CONTRAST;

        test.setValue(99.0);

        try {
            BufferedImage rc = test.process(ImageIO.read(new File("./src/main/resources/test_files/Wikipedia_Test_Artikel.PNG")));

            ImageIO.write(rc, "png", new File("./src/main/resources/test_files/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}