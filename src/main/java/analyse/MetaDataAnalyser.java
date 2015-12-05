package analyse;

import control.result.MetaData;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by florian on 23.11.15.
 */
public class MetaDataAnalyser implements Analyser<MetaData> {

    private final OCRAnalyser ocrAnalyser;

    public MetaDataAnalyser(){
        ocrAnalyser = new OCRAnalyser();
    }

    @Override
    public MetaData analyse(BufferedImage image, Rectangle rectangle) {
        String result = ocrAnalyser.analyse(image, rectangle);

        return process(result);
    }

    private MetaData process(String result) {
        MetaData md = new MetaData();



        return md;
    }
}
