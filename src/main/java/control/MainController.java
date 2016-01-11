package control;

import analyse.AnalyseType;
import analyse.ImageExtractor;
import analyse.MetaDataAnalyser;
import analyse.OCRAnalyser;
import control.configuration.LayoutConfiguration;
import control.configuration.LayoutFragment;
import control.factories.LayoutConfigurationFactory;
import control.factories.LayoutFragmentFactory;
import control.result.Result;
import control.result.Type;
import org.slf4j.LoggerFactory;
import postprocessing.PostProcessor;
import preprocessing.PreProcessingType;
import preprocessing.PreProcessor;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * controller der den workflow stuert
 * Created by FRudi on 06.11.2015.
 */
public class MainController {

    public MainController(){

    }

    @Deprecated
    public List<IIOImage> getIIOImageList(BufferedImage bi) throws IOException {
        List<IIOImage> iioImageList = new ArrayList<IIOImage>();
        IIOImage oimage = new IIOImage(bi, null, null);
        iioImageList.add(oimage);
        return iioImageList;
    }

    /**
     * analysiert das Bild mit den übergebenen configurationen
     * wenn keine konfiguration oder keine rechtecke zur analyse vorhanden sind, wird das komplette bild analysiert
     * @param image zu analysierende bild
     * @param configuration configuration für die analyse
     * @return ergebnis der analyse
     */
    public Result analyse (BufferedImage image, LayoutConfiguration configuration) {
        Result rc = new Result();
/*
        try {
            List<IIOImage> list = getIIOImageList(image);
            for (IIOImage io :list) {
                LoggerFactory.getLogger("ocr_analyse").info("in liste: " + io);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        List<PreProcessor> preProcessor = configuration.getPreProcessors();
        Collections.sort(preProcessor);
        for (PreProcessor processor : preProcessor) {
            image = processor.process(image);
        }

        if(configuration.getFragments() == null || configuration.getFragments().size() == 0){
            LoggerFactory.getLogger("ocr_analyse").info("bin im default keine angaben");
            Rectangle rectangle = new Rectangle();

            int xStart = 0;
            int yStart = 0;
            int xEnd = image.getWidth();
            int yEnd = image.getHeight();

            rectangle.setBounds(xStart, yStart, xEnd - xStart, yEnd - yStart);

            rc.addResultFragment(AnalyseType.TEXT_FRAGMENT.getAnalyser().analyse(image, rectangle), 0, 0, 1, 1, Type.TEXT);
        }else{
            for (LayoutFragment fragment: configuration.getFragments()){
                Rectangle rectangle = new Rectangle();

                int xStart = (int) (fragment.getxStart() * image.getWidth());
                int yStart = (int) (fragment.getyStart() * image.getHeight());
                int xEnd = (int) (fragment.getxEnd() * image.getWidth());
                int yEnd = (int) (fragment.getyEnd() * image.getHeight());

                /*
                int xStart = (int) fragment.getxStart();
                int yStart = (int) fragment.getyStart();
                int xEnd = (int) fragment.getxEnd();
                int yEnd = (int) fragment.getyEnd();
                */

                rectangle.setBounds(xStart, yStart, xEnd - xStart, yEnd - yStart);

                Type type;

                if(fragment.getType().getAnalyser() instanceof OCRAnalyser){
                    type = Type.TEXT;
                }else if(fragment.getType().getAnalyser() instanceof ImageExtractor){
                    type = Type.IMAGE;
                }else if(fragment.getType().getAnalyser() instanceof MetaDataAnalyser) {
                    type = Type.META;
                }else{
                    type = Type.TEXT;
                }

                rc.addResultFragment(fragment.getType().getAnalyser().analyse(image, rectangle),
                        fragment.getxStart(),
                        fragment.getyStart(),
                        fragment.getxEnd(),
                        fragment.getyEnd(),
                        type);
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
            image = ImageIO.read(new File("./src/main/resources/test_files/test_300_dpi.jpg"));
            //image = ImageIO.read(new File("./src/main/resources/test_files/TUEV Angebot 2.png"));
            //image = ImageIO.read(URI.create("https://owncloud.v22015042759824376.yourvserver.net/index.php/apps/files_sharing/ajax/publicpreview.php?x=1920&y=589&a=true&file=20151218_143333_HDR.jpg&t=ZiHNPuZBZEL2k0m&scalingup=0").toURL());
            //image = ImageIO.read(URI.create("http://favim.com/orig/201108/19/black-and-white-cool-simple-text-Favim.com-125982.jpg").toURL());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("image geladen!");

        Result result = controller.analyse(image, new LayoutConfigurationFactory()
               /* .addLayoutFragment(new LayoutFragmentFactory()
                        .addXStart(0)
                        .addXEnd(0)
                        .addYStart(image.getWidth())
                        .addYEnd(image.getHeight())
                        .addType(AnalyseType.TEXT_FRAGMENT)
                        .build())*/
                .build());

        System.out.println(result.getResultFragments().get(0).getResult());
    }
}
