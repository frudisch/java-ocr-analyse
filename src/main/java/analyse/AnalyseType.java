package analyse;

/**
 * Created by florian on 23.11.15.
 */
public class AnalyseType {

    public static AnalyseType TEXT_FRAGMENT = new AnalyseType(new OCRAnalyser());
    public static AnalyseType META_DATA_FRAGMENT = new AnalyseType(new MetaDataAnalyser());
    public static AnalyseType IMAGE_FRAGMENT = new AnalyseType(new ImageExtractor());

    private final Analyser analyser;

    private AnalyseType(Analyser analyser){
        this.analyser = analyser;
    }

    public Analyser getAnalyser() {
        return analyser;
    }
}
