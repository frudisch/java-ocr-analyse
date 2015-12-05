package control.result;

import java.util.HashMap;

/**
 * Created by florian on 24.11.15.
 */
public class MetaData {

    HashMap<String, String> data = new HashMap<>();

    public String getValue(String key){
        return data.get(key);
    }

    public void addValue(String key, String value){
        data.put(key, value);
    }

    public HashMap<String, String> getData() {
        return data;
    }

    public void setData(HashMap<String, String> data) {
        this.data = data;
    }
}
