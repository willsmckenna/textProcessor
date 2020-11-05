import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ToLowerFilter extends FilterObj {
    @Override
    public void transformData() throws IOException {
        ArrayList<String> res = new ArrayList<>();
        for (String line : data) {
            res.add(line.toLowerCase());
        }
        data = res;
    }
}
