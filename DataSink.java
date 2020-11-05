import java.util.*;

/**
 *  The final step of the pipeline, takes the words and frequencies and outputs the top 10.
 *                          Sorting stream inspired in part by Ousmane D. from
 *  https://stackoverflow.com/questions/48818051/how-to-sort-a-hashmap-first-by-value-and-then-by-key-in-case-of-duplicates
 */
public class DataSink extends FilterObj{

    @Override
    public void transformData() {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> sortedList = new ArrayList<>();

        for (String wordAndFreq: data){
            String word = wordAndFreq.split("=")[0];
            Integer freq = Integer.parseInt(wordAndFreq.split("=")[1]);
            map.put(word, freq);
       }

        map
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEachOrdered(e -> sortedList.add(e.getKey() + "=" + e.getValue()));


            printTopTen(sortedList);
    }

    private void printTopTen(ArrayList<String> list){
        int counter = 1;

        String firstWord = splitListItem(list.get(0))[0];
        String firstFreq = splitListItem(list.get(0))[1];

        System.out.println("MOST COMMON WORDS:");
        System.out.println(counter + ": " + firstWord + " - " + firstFreq);

        for (int i = 1; i<list.size(); i++){
            String word = splitListItem(list.get(i))[0];
            String freq = splitListItem(list.get(i))[1];
            if (freq.equals(splitListItem(list.get(i - 1))[1])){
                System.out.println("   tied with: " + word + " - " + freq);
            } else {
                counter += 1;
                System.out.println("-----------------------------------");
                System.out.println(counter + ": " + word + " - " + freq);
            }
            if (counter == 10)
                break;
        }
    }

    private String[] splitListItem(String item){
        return item.split("=");
    }

}
