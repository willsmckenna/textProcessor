import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;

public class PipeLine {

    LinkedList<FilterObj> nodes;
    LinkedList<PipeImpl> pipes;

    public PipeLine(LinkedList<FilterObj> nodes, LinkedList<PipeImpl> pipes) {
        this.nodes = nodes;
        this.pipes = pipes;
    }

    public static ArrayList<String> convertFile(File file) throws IOException {
        ArrayList<String> res = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            res.add(line);
        }
        return res;
    }

    public void connect() {
        int pipeCounter = 0;
        for (int i = 0; i < nodes.size() - 1; i++) {
            pipes.get(pipeCounter).setUpPipe(nodes.get(i), nodes.get(i + 1));
            pipeCounter += 1;
        }
    }

    public void execute() throws IOException {
        int pipeCounter = 0;
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).transformData();
            pipes.get(pipeCounter).transportData();
            pipeCounter += 1;
        }
        nodes.get(nodes.size() - 1).transformData();
    }
}
