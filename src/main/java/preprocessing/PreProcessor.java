package preprocessing;

import java.awt.*;

/**
 * Created by FRudi on 07.11.2015.
 */
public abstract class PreProcessor implements Comparable<PreProcessor>{

    abstract int getRanking();

    public abstract Image process(Image image);

    @Override
    public int compareTo(PreProcessor o){
        return getRanking() > o.getRanking()? 1 : 0;
    }
}
