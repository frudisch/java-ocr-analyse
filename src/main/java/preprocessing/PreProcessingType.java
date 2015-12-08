package preprocessing;

/**
 * Created by FRudi on 20.11.2015.
 */
public abstract class PreProcessingType {

    private static final int ROTATE_RANKING = 0;
    public static PreProcessor ROTATE = new RotatePreProcessor(ROTATE_RANKING);

    private static final int INCREASE_CONTRAST_RANKING = 100;
    public static PreProcessor INCREASE_CONTRAST = new ContrastPreProcessor(INCREASE_CONTRAST_RANKING);

    private static final int INCREASE_BRIGHTNESS_RANKING = 200;
    public static PreProcessor INCREASE_BRIGHTNESS = new BrightnessPreProcessor(INCREASE_BRIGHTNESS_RANKING);

}