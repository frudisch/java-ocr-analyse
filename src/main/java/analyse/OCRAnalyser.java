package analyse;

import ch.qos.logback.classic.Logger;
import control.result.Result;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Locale;

/**
 * linux needs tesseract ocr ist hier: http://stackoverflow.com/questions/26577644/tess4j-native-library-linux-x86-64-libtesseract-so-not-found-in-resource-pat
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
        image = new ImageExtractor().analyse(image, rectangle);
        LoggerFactory.getLogger("ocr_analyse").info("analyse: " + image + " xStart: " +rectangle.getX() + " yStart: " + rectangle.getY() + " width: " + rectangle.getWidth() + " height: " + rectangle.getHeight());
        try {
            return tesseract.doOCR(image);
        } catch (TesseractException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args){
        File test = new File("./src/main/resources/test_files/test.jpg");
        ITesseract tesseract = new Tesseract();

        tesseract.setLanguage("deu");

        try {
            System.out.println(tesseract.doOCR(test));
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}
