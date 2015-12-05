package control.factories;

import analyse.AnalyseType;
import control.configuration.LayoutFragment;

/**
 * Created by florian on 05.12.15.
 */
public class LayoutFragmentFactory {

    private LayoutFragment fragment = new LayoutFragment();

    public LayoutFragment build(){
        return fragment;
    }

    public LayoutFragmentFactory addType(AnalyseType type){
        fragment.setType(type);

        return this;
    }

    public LayoutFragmentFactory addXStart(double xStart){
        fragment.setxStart(xStart);

        return this;
    }

    public LayoutFragmentFactory addYStart(double yStart){
        fragment.setyStart(yStart);

        return this;
    }

    public LayoutFragmentFactory addXEnd(double xEnd){
        fragment.setxEnd(xEnd);

        return this;
    }

    public LayoutFragmentFactory addYEnd(double yEnd){
        fragment.setyEnd(yEnd);

        return this;
    }

}
