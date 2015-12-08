package preprocessing;

import net.sourceforge.jiu.color.adjustment.Brightness;
import net.sourceforge.jiu.color.adjustment.Contrast;
import net.sourceforge.jiu.data.PixelImage;
import net.sourceforge.jiu.gui.awt.BufferedRGB24Image;
import net.sourceforge.jiu.gui.awt.ImageCreator;
import net.sourceforge.jiu.ops.MissingParameterException;
import net.sourceforge.jiu.ops.WrongParameterException;

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

        BufferedRGB24Image bufferedRGB24Image = new BufferedRGB24Image(image);
        
        int scalefactor = (int) getValue();
        Contrast contrast = new Contrast();
        contrast.setInputImage(bufferedRGB24Image);
        contrast.setContrast(scalefactor);

        try {
            contrast.process();
            PixelImage pixelImage = contrast.getOutputImage();
            return ImageCreator.convertToAwtBufferedImage(pixelImage);

        } catch (MissingParameterException e) {
            e.printStackTrace();
        } catch (WrongParameterException e) {
            e.printStackTrace();
        }

        return image;
    }



    public static void main(String[] args){
        PreProcessor test = PreProcessingType.INCREASE_CONTRAST;

        test.setValue(50.0);

        try {
            BufferedImage rc = test.process(ImageIO.read(new File("./src/main/resources/test_files/input.png")));

            ImageIO.write(rc, "png", new File("./src/main/resources/test_files/output.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}