package control.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by FRudi on 20.11.2015.
 */
public class LayoutConfiguration {

    private List<LayoutFragment> fragments;
    private Locale isoLanguage;

    /*
    Standard Configuration with empty fragments and german language
    => complete document will be analysed with tesseract
     */
    public LayoutConfiguration(){
        setFragments(new ArrayList<>());
        setIsoLanguage(Locale.GERMAN);
    }

    public LayoutConfiguration(List<LayoutFragment> fragments, Locale isoLanguage){
        setFragments(fragments);
        setIsoLanguage(isoLanguage);
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
}
