package control;

import analyse.AnalyseType;
import analyse.OCRAnalyser;
import control.configuration.LayoutConfiguration;
import control.configuration.LayoutFragment;
import control.factories.LayoutConfigurationFactory;
import control.factories.LayoutFragmentFactory;
import control.result.Result;
import postprocessing.PostProcessor;
import preprocessing.PreProcessor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by FRudi on 06.11.2015.
 */
public class MainController {

    public MainController(){

    }

    public Result analyse (BufferedImage image, LayoutConfiguration configuration) {
        Result rc = new Result();

        List<PreProcessor> preProcessor = configuration.getPreProcessors();
        Collections.sort(preProcessor);
        for (PreProcessor processor : preProcessor) {
            processor.process(image);
        }

        if(configuration.getFragments() == null || configuration.getFragments().size() == 0){
            Rectangle rectangle = new Rectangle();

            int xStart = 0;
            int yStart = 0;
            int xEnd = image.getWidth();
            int yEnd = image.getHeight();

            rectangle.setBounds(xStart, yStart, xEnd - xStart, yEnd - yStart);

            rc.addResultFragment(AnalyseType.TEXT_FRAGMENT.getAnalyser().analyse(image, rectangle),
                    AnalyseType.TEXT_FRAGMENT);
        }else{
            for (LayoutFragment fragment: configuration.getFragments()){
                Rectangle rectangle = new Rectangle();

                int xStart = (int) fragment.getxStart() * image.getWidth();
                int yStart = (int) fragment.getyStart() * image.getHeight();
                int xEnd = (int) fragment.getxEnd() * image.getWidth();
                int yEnd = (int) fragment.getyEnd() * image.getHeight();

                rectangle.setBounds(xStart, yStart, xEnd - xStart, yEnd - yStart);

                rc.addResultFragment(fragment.getType().getAnalyser().analyse(image, rectangle),
                        fragment.getType());
            }
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
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File("./src/main/resources/test_files/Wikipedia_Test_Artikel.PNG"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Result result = controller.analyse(image, new LayoutConfigurationFactory()
                .addLayoutFragment(new LayoutFragmentFactory()
                        .addXStart(0)
                        .addXEnd(0)
                        .addYStart(image.getWidth())
                        .addYEnd(image.getHeight())
                        .addType(AnalyseType.TEXT_FRAGMENT)
                        .build())
                .build());

        System.out.println(result.getResultFragments().get(0).getResult());
    }
}
