import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;

public class StopWordFilter extends FilterObj {

    @Override
    public void transformData() throws IOException {
        File file = new File("C:\\Users\\wills\\Desktop\\textProcessor\\src\\main\\resources\\stopwords.txt");
        ArrayList<String> stopWords = PipeLine.convertFile(file);
        ArrayList<String> res = new ArrayList<>();
        for (String line : data) {
            for (String s : line.split(" ")) {
                if (!stopWords.contains(s)) {
                    res.add(s);
                }
            }
        }
        data = res;
    }
}
