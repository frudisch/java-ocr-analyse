package analyse;

import ch.qos.logback.classic.Logger;
import control.result.Result;
import net.sourceforge.tess4j.*;
import net.sourceforge.tess4j.util.LoadLibs;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

/**
 * linux needs tesseract ocr ist hier: http://stackoverflow.com/questions/26577644/tess4j-native-library-linux-x86-64-libtesseract-so-not-found-in-resource-pat
 *
 * Created by FRudi on 06.11.2015.
 */
public class OCRAnalyser implements Analyser<String>{

    private ITesseract tesseract;

    int i = 0;

    public OCRAnalyser(){
        tesseract = new Tesseract();

        //In case you don't have your own tessdata, let it also be extracted for you
        File tessDataFolder = LoadLibs.extractTessResources("tessdata");

        //Set the tessdata path
        tesseract.setDatapath(tessDataFolder.getAbsolutePath());
        tesseract.setPageSegMode(ITessAPI.TessPageSegMode.PSM_SINGLE_BLOCK);
    }

    /**
     *
     * @param val
     */
    @Override
    public void setValue(String val) {
        tesseract.setLanguage(val);
    }

    /**
     * extrahiert das bild aus dem definierten bereich mittels des ImageExtractor und analysiert
     * danach das ausgeschnittene bild mittels Tesseract und gibt den gefundenen text zurück
     * @param image zu analysierendes Bild
     * @param rectangle zu analysierender Bereich
     * @return im bild gefundener text
     */
    @Override
    public String analyse(BufferedImage image, Rectangle rectangle) {
        BufferedImage cutImage = new ImageExtractor().analyse(image, rectangle);

        /*
        try {
            ImageIO.write(cutImage, "png", new File("./tempPic_" + i + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        i++;
        try {
            return tesseract.doOCR(cutImage);
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
