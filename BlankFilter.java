import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class BlankFilter extends FilterObj {
    @Override
    public void transformData() throws IOException {

        ArrayList<String> res = new ArrayList<>();
        for (String line : data) {
            if (!line.isEmpty())
                res.add(line);
        }
        data = res;

    }
}
