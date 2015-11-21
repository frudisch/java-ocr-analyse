package postprocessing;

import control.result.Result;
import org.apache.commons.lang.SystemUtils;
import org.apache.lucene.search.spell.PlainTextDictionary;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by FRudi on 07.11.2015.
 */
public class LuceneSpellChecker extends PostProcessor{

    private SpellChecker spellChecker;

    public LuceneSpellChecker(){
        File temp = new File("./test.txt");
        System.out.println(temp.getAbsolutePath() + " " + temp.isFile());
        File dir = new File("./src/main/resources/spellchecker");
        System.out.println(dir.isDirectory());
        try {
            Directory directory = FSDirectory.open(Paths.get(dir.toURI()));
            spellChecker = new SpellChecker(directory);
            spellChecker.indexDictionary(new PlainTextDictionary(new File("./src/main/resources/spellchecker/dictionary/full_dictionary00.txt")), null, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(Result result) {
        String rc = "";
        String wordForSuggestions = "hwllo";
        int suggestionsNumber = 5;
        String[] suggestions = new String[0];
        try {
            suggestions = spellChecker.suggestSimilar(wordForSuggestions, suggestionsNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (suggestions!=null && suggestions.length>0) {
            for (String word : suggestions) {
                System.out.println("Did you mean:" + word);
            }
        }
        else {
            System.out.println("No suggestions found for word:"+wordForSuggestions);
        }

    }

    @Override
    int getRanking() {
        return 0;
    }

    public static void main(String[] args){

    }
}
