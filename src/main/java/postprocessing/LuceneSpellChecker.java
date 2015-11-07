package postprocessing;

/**
 * Created by FRudi on 07.11.2015.
 */
public class LuceneSpellChecker implements PostProcessor{

    public LuceneSpellChecker(){

    }

    @Override
    public String process(String extractedText) {
        return null;
    }

    public static void main(String[] args){
        new LuceneSpellChecker().process("A santance wlth a erorr in the Hitchhiker's Guide tot he Galxy");
    }
}
