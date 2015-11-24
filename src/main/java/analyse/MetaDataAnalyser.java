package analyse;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by florian on 23.11.15.
 */
public class MetaDataAnalyser implements Analyser {

    private final OCRAnalyser ocrAnalyser;

    public MetaDataAnalyser(){
        ocrAnalyser = new OCRAnalyser();
    }

    @Override
    public MetaData analyse(BufferedImage image, Rectangle rectangle) {
        String result = ocrAnalyser.analyse(image, rectangle);

        return null;
    }
}
