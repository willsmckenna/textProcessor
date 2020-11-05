import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * The stemming filter, where it takes the words coming in as lines, translates
 * them down to their root form. The words are then filtered into a new list as
 * a large array of seperate words
 */
public class StemFilter extends FilterObj {

    @Override
    public void transformData() throws IOException {
        ArrayList<String> res = new ArrayList<>();
        Stemmer stemmer = new Stemmer();
        for (String word : data) {
            if (!word.isEmpty()) {
                for (Character c : word.toCharArray()) {
                    stemmer.add(c);
                }
                stemmer.stem();
                res.add(stemmer.toString());
            }
        }
        data = res;
    }
}
