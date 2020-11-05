import java.io.IOException;
import java.util.ArrayList;

public abstract class FilterObj implements Filter {
    ArrayList<String> data;

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }


    public abstract void transformData() throws IOException;

}
