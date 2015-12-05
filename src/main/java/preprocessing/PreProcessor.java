package preprocessing;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by FRudi on 07.11.2015.
 */
public abstract class PreProcessor implements Comparable<PreProcessor>{

    private double value;
    private int ranking;

    public PreProcessor(int ranking){
        setRanking(ranking);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public abstract BufferedImage process(BufferedImage image);

    @Override
    public int compareTo(PreProcessor o){
        return getRanking() > o.getRanking()? 1 : 0;
    }
}
