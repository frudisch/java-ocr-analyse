package analyse;

import control.result.Result;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * linux needs tesseract ocr => http://stackoverflow.com/questions/26577644/tess4j-native-library-linux-x86-64-libtesseract-so-not-found-in-resource-pat
 *
 * Created by FRudi on 06.11.2015.
 */
public class OCRAnalyser implements Analyser<String>{

    private ITesseract tesseract;

    public OCRAnalyser(){
        tesseract = new Tesseract();

        tesseract.setLanguage("deu");
    }

    @Override
    public String analyse(BufferedImage image, Rectangle rectangle) {
        try {
            return tesseract.doOCR(image, rectangle);
        } catch (TesseractException e) {
            e.printStackTrace();
            return "";
        }
    }
}
