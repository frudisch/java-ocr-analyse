package preprocessing;

import ij.ImagePlus;
import ij.plugin.ContrastEnhancer;
import ij.process.ColorProcessor;
import ij.process.FloatProcessor;
import ij.process.ImageProcessor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
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

        ImagePlus im = new ImagePlus("Image", image);
        ContrastEnhancer enh = new ContrastEnhancer();
        enh.stretchHistogram(im, getValue());
        return im.getBufferedImage();


        /*
        ImagePlus imagePlus = new ImagePlus("Image", image);
        ImageProcessor imageProcessor = imagePlus.getProcessor();

        ColorProcessor temp = (ColorProcessor) imageProcessor;

        float[] roi = new float[image.getHeight()*image.getWidth()];
        for(int i = 0; i<image.getHeight()*image.getWidth(); i++){
            roi[i] = 25;
        }

        temp.setBrightness(new FloatProcessor(image.getWidth(), image.getHeight(), roi));


        return temp.getBufferedImage();
        */
    }



    public static void main(String[] args){
        PreProcessor test = PreProcessingType.INCREASE_CONTRAST;

        test.setValue(50.0);

        try {
            BufferedImage rc = test.process(ImageIO.read(new File("./src/main/resources/test_files/00_USA_ROADTRIP.png")));

            ImageIO.write(rc, "png", new File("./src/main/resources/test_files/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}