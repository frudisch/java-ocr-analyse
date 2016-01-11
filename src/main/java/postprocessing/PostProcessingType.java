package postprocessing;

/**
 * liste der postprocessoren
 * Created by FRudi on 22.11.2015.
 */
public abstract class PostProcessingType {

    public static PostProcessor TEXT_CHECK = new LanguageTool();

}
