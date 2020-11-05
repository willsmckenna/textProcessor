import java.sql.Timestamp;
import java.util.ArrayList;

public class AlphaFilter extends FilterObj {

    @Override
    public void transformData() {

        ArrayList<String> res = new ArrayList<>();
        for (String line : data) {
            // goes through each line, if there is a non-alpha character replaces it with
            // nothing
            String newLine = line.replaceAll("[^a-zA-Z ]", "");
            res.add(newLine.trim());
        }
        data = res;

    }
}
