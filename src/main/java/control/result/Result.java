package control.result;

import analyse.AnalyseType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FRudi on 20.11.2015.
 */
public class Result {

    private List<ResultFragment> resultFragments = new ArrayList<>();

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
