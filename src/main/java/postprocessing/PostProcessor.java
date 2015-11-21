package postprocessing;

import control.result.Result;

import java.awt.*;

/**
 * Interface for PreProcessing Purpose
 *
 * Created by FRudi on 06.11.2015.
 */
public abstract class PostProcessor implements Comparable<PostProcessor>{

    public abstract void process(Result rc);

    abstract int getRanking();

    @Override
    public int compareTo(PostProcessor o){
        return getRanking() > o.getRanking()? 1 : 0;
    }
}

