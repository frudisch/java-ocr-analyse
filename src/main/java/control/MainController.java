package control;

import analyse.AnalyseController;
import control.configuration.LayoutConfiguration;
import control.configuration.LayoutFragment;
import control.result.Result;
import postprocessing.PostProcessor;
import preprocessing.PreProcessor;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by FRudi on 06.11.2015.
 */
public class MainController {

    private final AnalyseController analyser;

    public MainController(){
        analyser = new AnalyseController();
    }

    public Result analyse (Image image, LayoutConfiguration configuration){
        Result rc = new Result();

        for (LayoutFragment fragment: configuration.getFragments()) {
            List<PreProcessor> preProcessor = getPreProcessorFromTypes(fragment);
            Collections.sort(preProcessor);

            for (PreProcessor processor: preProcessor) {
                processor.process(image);
            }

            analyser.analyse(image, rc);

            List<PostProcessor> postProcessor = getPostProcessorFromTypes(fragment);
            Collections.sort(postProcessor);

            for (PostProcessor processor: postProcessor) {
                processor.process(rc);
            }
        }

        return rc;
    }


    public static void main(String[] args){
        MainController controller = new MainController();
    }
}
