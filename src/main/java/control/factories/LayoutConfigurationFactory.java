package control.factories;

import control.configuration.LayoutConfiguration;
import control.configuration.LayoutFragment;
import postprocessing.PostProcessor;
import preprocessing.PreProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by florian on 05.12.15.
 */
public class LayoutConfigurationFactory {

    private LayoutConfiguration configuration = new LayoutConfiguration();
    private List<LayoutFragment> fragmentList = new ArrayList<>();
    private List<PreProcessor> preProcessors = new ArrayList<>();
    private List<PostProcessor> postProcessors = new ArrayList<>();

    public LayoutConfiguration build(){
        configuration.setFragments(fragmentList);
        configuration.setPreProcessors(preProcessors);
        configuration.setPostProcessors(postProcessors);

        return configuration;
    }

    public LayoutConfigurationFactory addLanguage(Locale language){
        configuration.setIsoLanguage(language);

        return this;
    }

    public LayoutConfigurationFactory addPreProcessor(PreProcessor processor){
        preProcessors.add(processor);

        return this;
    }

    public LayoutConfigurationFactory addPostProcessor(PostProcessor processor){
        postProcessors.add(processor);

        return this;
    }

    public LayoutConfigurationFactory addLayoutFragment(LayoutFragment fragment) {
        fragmentList.add(fragment);

        return this;
    }
}
