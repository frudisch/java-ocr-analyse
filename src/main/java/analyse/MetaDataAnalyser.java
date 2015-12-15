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

        String[] splittedArray = result.split(":");

        for(int i = 0; i<splittedArray.length; i++){
            String key, value;

            key = splittedArray[i].split(" ")[splittedArray[i].split(" ").length - 1];
            value = splittedArray[i + 1].split(" ")[0];

            md.addValue(key, value);
        }

        return md;
    }
}
