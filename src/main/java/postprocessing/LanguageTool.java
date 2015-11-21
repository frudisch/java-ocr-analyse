package postprocessing;

import control.result.Result;
import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.Rule;
import org.languagetool.rules.RuleMatch;
import org.languagetool.rules.spelling.SpellingCheckRule;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by FRudi on 07.11.2015.
 */
public class LanguageTool extends PostProcessor{

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

    public static void main(String[] args){
    }
}
