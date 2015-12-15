package control.result;

import analyse.AnalyseType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FRudi on 20.11.2015.
 */
public class Result {

    private List<ResultFragment> resultFragments = new ArrayList<>();

    public <T> ResultFragment<T> addResultFragment(T result, AnalyseType type){
        ResultFragment<T> temp = new ResultFragment<T>();
        temp.setResult(result);
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
