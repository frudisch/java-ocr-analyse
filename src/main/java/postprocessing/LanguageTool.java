package postprocessing;

import control.result.Result;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * wird nicht benutzt
 * Created by FRudi on 07.11.2015.
 */
public class LanguageTool extends PostProcessor{
/*
    private final JLanguageTool lt;

    public LanguageTool(){
        lt = new JLanguageTool(new AmericanEnglish());
    }

    @Override
    public void process(Result result) {
        String rc = "";
        List<RuleMatch> matches = null;
        try {
            matches = lt.check("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (RuleMatch match : matches) {
            System.out.println("Potential error at line " +
                    match.getLine() + ", column " +
                    match.getColumn() + ": " + match.getMessage());
            System.out.println("Suggested correction: " +
                    match.getSuggestedReplacements());
        }

    }

    @Override
    int getRanking() {
        return 0;
    }
*/
@Override
public void process(Result result) {

}

    @Override
    int getRanking() {
        return 0;
    }
    public static void main(String[] args){
    }
}
