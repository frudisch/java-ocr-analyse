package control;

import analyse.OCRAnalyser;
import control.configuration.LayoutConfiguration;
import control.configuration.LayoutFragment;
import control.result.Result;
import postprocessing.PostProcessor;
import preprocessing.PreProcessor;

import java.awt.*;
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

    public Result analyse (Image image, LayoutConfiguration configuration) {
        Result rc = new Result();
        ImageCutter cutter = new ImageCutter();

        List<PreProcessor> preProcessor = configuration.getPreProcessors();
        Collections.sort(preProcessor);
        for (PreProcessor processor : preProcessor) {
            processor.process(image);
        }

        for (LayoutFragment fragment: configuration.getFragments()){
            Image cutted = cutter.process(image, fragment);

            //TODO
            fragment.getType().getAnalyser().analyse();
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
