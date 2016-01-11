package control.result;

import analyse.AnalyseType;

import java.util.ArrayList;
import java.util.List;

/**
 * ergebnis der analyse
 * Created by FRudi on 20.11.2015.
 */
public class Result {

    private List<ResultFragment> resultFragments = new ArrayList<>();

    /**
     * fügt neues ergebnis fragment den resultfragmenten hinzu, dafür werden alle variablen gesetzt
     * @param result ergebnis der analyse
     * @param xStart x start rechtecks
     * @param yStart y start rechtecks
     * @param xEnd x ende rechtecks
     * @param yEnd y ende rechtecks
     * @param type typ der analyse
     * @param <T> typ des ergebnisses
     * @return erstelltes ergebnis
     */
    public <T> ResultFragment<T> addResultFragment(T result, double xStart, double yStart, double xEnd, double yEnd, Type type){
        ResultFragment<T> temp = new ResultFragment<>();

        temp.setResult(result);
        temp.setEndX(xEnd);
        temp.setEndY(yEnd);
        temp.setStartX(xStart);
        temp.setStartY(yStart);
        temp.setType(type);

        addResultFragment(temp);

        return temp;
    }

    public void addResultFragment(ResultFragment fragment){
        resultFragments.add(fragment);
    }

    public List<ResultFragment> getResultFragments() {
        return resultFragments;
    }

    public void setResultFragments(List<ResultFragment> resultFragments) {
        this.resultFragments = resultFragments;
    }
}
