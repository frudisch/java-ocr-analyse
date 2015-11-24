package control;

import analyse.OCRAnalyser;
import control.configuration.LayoutConfiguration;
import control.configuration.LayoutFragment;
import control.result.Result;
import postprocessing.PostProcessor;
import preprocessing.PreProcessor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.List;

/**
 * Created by FRudi on 06.11.2015.
 */
public class MainController {

    private final OCRAnalyser analyser;

    public MainController(){
        analyser = new OCRAnalyser();
    }

    public Result analyse (BufferedImage image, LayoutConfiguration configuration) {
        Result rc = new Result();

        List<PreProcessor> preProcessor = configuration.getPreProcessors();
        Collections.sort(preProcessor);
        for (PreProcessor processor : preProcessor) {
            processor.process(image);
        }

        for (LayoutFragment fragment: configuration.getFragments()){
            Rectangle rectangle = new Rectangle();

            int xStart = (int) fragment.getxStart() * image.getWidth();
            int yStart = (int) fragment.getyStart() * image.getHeight();
            int xEnd = (int) fragment.getxEnd() * image.getWidth();
            int yEnd = (int) fragment.getyEnd() * image.getHeight();

            rectangle.setBounds(xStart, yStart, xEnd - xStart, yEnd - yStart);

            fragment.getType().getAnalyser().analyse(image, rectangle);
        }

        List<PostProcessor> postProcessor = configuration.getPostProcessors();
        Collections.sort(postProcessor);
        for (PostProcessor processor : postProcessor) {
            processor.process(rc);
        }

        return rc;
    }


    public static void main(String[] args){
        MainController controller = new MainController();
    }
}
