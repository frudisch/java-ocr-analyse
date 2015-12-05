package control.result;

import analyse.AnalyseType;

/**
 * Created by FRudi on 20.11.2015.
 */
public class ResultFragment<T> {

    private T result;
    private AnalyseType type;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public AnalyseType getType() {
        return type;
    }

    public void setType(AnalyseType type) {
        this.type = type;
    }
}
