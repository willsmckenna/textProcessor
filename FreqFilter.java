import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FreqFilter extends FilterObj {

    @Override
    public void transformData() {
        ArrayList<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : data) {
            if (!map.containsKey(s)) {
                int frequencyOfWord = Collections.frequency(data, s);
                map.put(s, frequencyOfWord);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getKey() + "=" + entry.getValue());
        }
        data = res;
    }
}
