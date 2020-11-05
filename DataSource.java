import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Where the pipeline begins. The DataSource takes the .txt files and converts
 * them to an arrayList of strings.
 */

public class DataSource extends FilterObj {
    File file;

    public DataSource(File file) {
        this.file = file;
    }

    @Override
    public void transformData() throws IOException {
        ArrayList<String> res;
        res = PipeLine.convertFile(file);
        data = res;
    }
}
