package preprocessing;

import ij.ImagePlus;
import ij.process.ImageConverter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Benedikt Linke on 23.11.15.
 */
public class GreyScalePreProcessor extends PreProcessor {

    public GreyScalePreProcessor(int ranking) {
        super(ranking);
    }

    @Override
    public BufferedImage process(BufferedImage image) {

        ImagePlus imp = new ImagePlus("Image", image);
        ImageConverter ic = new ImageConverter(imp);
        ic.convertToGray8();
        imp.updateAndDraw();

        return imp.getBufferedImage();
    }


    public static void main(String[] args){
        PreProcessor test = PreProcessingType.GREY_SCALE;

        test.setValue(50.0);

        try {
            BufferedImage rc = test.process(ImageIO.read(new File("./src/main/resources/test_files/00_USA_ROADTRIP.png")));

            ImageIO.write(rc, "png", new File("./src/main/resources/test_files/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
