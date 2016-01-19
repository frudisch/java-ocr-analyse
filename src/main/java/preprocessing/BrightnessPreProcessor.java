package preprocessing;

import net.sourceforge.jiu.color.adjustment.Brightness;
import net.sourceforge.jiu.data.PixelImage;
import net.sourceforge.jiu.gui.awt.BufferedRGB24Image;
import net.sourceforge.jiu.gui.awt.ImageCreator;
import net.sourceforge.jiu.ops.MissingParameterException;
import net.sourceforge.jiu.ops.WrongParameterException;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Benedikt Linke on 07.12.15.
 */
public class BrightnessPreProcessor extends PreProcessor {

    public BrightnessPreProcessor(int ranking) {
        super(ranking);
    }

    /**
     * erhöht oder verringert den lichtwert des übergebenen bildes um den in der value angegeben wert und gibt das bearbeitete bild zurück
     * @param image zu bearbeitendes bild
     * @return bearbeitetes bild
     */
    @Override
    public BufferedImage process(BufferedImage image) {
        LoggerFactory.getLogger("ocr_analyse").info("change brightness: " + getValue());
        BufferedRGB24Image bufferedRGB24Image = new BufferedRGB24Image(image);

        int scalefactor = (int) getValue();
        Brightness brightness = new Brightness();
        brightness.setInputImage(bufferedRGB24Image);
        brightness.setBrightness(scalefactor);

        try {
            brightness.process();
            PixelImage pixelImage = brightness.getOutputImage();
            return ImageCreator.convertToAwtBufferedImage(pixelImage);

        } catch (MissingParameterException e) {
            e.printStackTrace();
        } catch (WrongParameterException e) {
            e.printStackTrace();
        }

        return image;
    }



    public static void main(String[] args){
        PreProcessor test = PreProcessingType.INCREASE_BRIGHTNESS;

        test.setValue(-60.0);

        try {
            BufferedImage rc = test.process(ImageIO.read(new File("./src/main/resources/test_files/test_300_dpi.jpg")));

            ImageIO.write(rc, "png", new File("./src/main/resources/test_files/brightness_image_test_result.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
