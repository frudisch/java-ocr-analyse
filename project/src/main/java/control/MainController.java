package src.main.java.control;

import src.main.java.analyse.AnalyseController;
import src.main.java.postprocessing.PreProcessor;
import src.main.java.preprocessing.PostProcessor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FRudi on 06.11.2015.
 */
public class MainController {

    private final AnalyseController analyser;
    private List<PreProcessor> preProcessor;
    private List<PostProcessor> postProcessor;

    public MainController(){
        analyser = new AnalyseController();
    }

    private void analysePicture(String s) {
        Image temp = null;
        for (PreProcessor preProc: preProcessor) {
            preProc.process(temp);
        }
        String analysedText =  analyser.analyse(temp);
        for(PostProcessor postProc: postProcessor){
            analysedText = postProc.process(analysedText);
        }

    }

    private void analysePicture(List<PreProcessor> preProcessor, List<PostProcessor> postProcessor, String s) {
        setPreProcessor(preProcessor);
        setPostProcessor(postProcessor);
        analysePicture(s);
    }

    public List<PostProcessor> getPostProcessor() {
        return postProcessor;
    }

    public void setPostProcessor(List<PostProcessor> postProcessor) {
        this.postProcessor = postProcessor;
    }

    public List<PreProcessor> getPreProcessor() {
        return preProcessor;
    }

    public void setPreProcessor(List<PreProcessor> preProcessor) {
        this.preProcessor = preProcessor;
    }

    public static void main(String[] args){
        MainController controller = new MainController();
        controller.setPreProcessor(new ArrayList<>());
        controller.setPostProcessor(new ArrayList<>());
        controller.analysePicture("");
    }
}
