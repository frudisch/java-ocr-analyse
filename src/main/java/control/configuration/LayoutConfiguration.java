package control.configuration;

import postprocessing.PostProcessor;
import preprocessing.PreProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by FRudi on 20.11.2015.
 */
public class LayoutConfiguration {

    private List<LayoutFragment> fragments;
    private Locale isoLanguage;
    private List<PreProcessor> preProcessors;
    private List<PostProcessor> postProcessors;

    /*
    Standard Configuration with empty fragments and german language
    => complete document will be analysed with tesseract
     */
    public LayoutConfiguration(){
        setFragments(new ArrayList<>());
        setIsoLanguage(Locale.GERMAN);
    }

    public LayoutConfiguration(List<LayoutFragment> fragments, Locale isoLanguage, List<PreProcessor> preProcessors, List<PostProcessor> postProcessors){
        setFragments(fragments);
        setIsoLanguage(isoLanguage);
        setPreProcessors(preProcessors);
        setPostProcessors(postProcessors);
    }

    public List<LayoutFragment> getFragments() {
        return fragments;
    }

    public void setFragments(List<LayoutFragment> fragments) {
        this.fragments = fragments;
    }

    public Locale getIsoLanguage() {
        return isoLanguage;
    }

    public void setIsoLanguage(Locale isoLanguage) {
        this.isoLanguage = isoLanguage;
    }

    public List<PreProcessor> getPreProcessors() {
        return preProcessors;
    }

    public void setPreProcessors(List<PreProcessor> preProcessors) {
        this.preProcessors = preProcessors;
    }

    public List<PostProcessor> getPostProcessors() {
        return postProcessors;
    }

    public void setPostProcessors(List<PostProcessor> postProcessors) {
        this.postProcessors = postProcessors;
    }
}
