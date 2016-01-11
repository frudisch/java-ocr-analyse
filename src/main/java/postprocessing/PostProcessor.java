package postprocessing;

import control.result.Result;

import java.awt.*;

/**
 * Interface for PreProcessing Purpose
 *
 * Created by FRudi on 06.11.2015.
 */
public abstract class PostProcessor implements Comparable<PostProcessor>{

    /**
     * verarbeitet das ergebnis
     * @param rc ergebnis
     */
    public abstract void process(Result rc);

    /**
     * gibt die reihenfolge für die abarbeitung aller processoren an
     * @return platz in der rangliste
     */
    abstract int getRanking();

    /**
     * zum vergleich der processoren
     * @param o zu vergleichender processor
     * @return
     */
    @Override
    public int compareTo(PostProcessor o){
        return getRanking() > o.getRanking()? 1 : 0;
    }
}

