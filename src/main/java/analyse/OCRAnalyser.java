package analyse;

import control.result.Result;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by FRudi on 06.11.2015.
 */
public class OCRAnalyser implements Analyser{

    private ITesseract tesseract;

    public OCRAnalyser(){
        tesseract = new Tesseract();
    }

    @Override
    public String analyse(BufferedImage image, Rectangle rectangle) {
        try {
            return tesseract.doOCR(image,rectangle);
        } catch (TesseractException e) {
            e.printStackTrace();
            return "";
        }
    }
}
