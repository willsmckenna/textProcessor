import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static LinkedList<FilterObj> nodes = new LinkedList<>();
    static LinkedList<PipeImpl> pipes = new LinkedList<>();

    public static void setUpPipeLine(String f) {

        String path = getRootDirPath();
        System.out.println(path);
        File file = new File(path + "\\" + f);

        FilterObj dataSource = new DataSource(file);
        FilterObj trimFilter = new TrimFilter();
        FilterObj blankFilter = new BlankFilter();
        FilterObj alphaFilter = new AlphaFilter();
        FilterObj toLowerFilter = new ToLowerFilter();
        FilterObj stopWordFilter = new StopWordFilter();
        FilterObj stemFilter = new StemFilter();
        FilterObj freqFilter = new FreqFilter();
        FilterObj dataSink = new DataSink();

        nodes.add(dataSource);
        nodes.add(trimFilter);
        nodes.add(blankFilter);
        nodes.add(alphaFilter);
        nodes.add(toLowerFilter);
        nodes.add(stopWordFilter);
        nodes.add(stemFilter);
        nodes.add(freqFilter);
        nodes.add(dataSink);

        PipeImpl sourceToTrim = new PipeImpl();
        PipeImpl trimToBlank = new PipeImpl();
        PipeImpl blankToAlpha = new PipeImpl();
        PipeImpl alphaToLower = new PipeImpl();
        PipeImpl lowerToStop = new PipeImpl();
        PipeImpl stopToStem = new PipeImpl();
        PipeImpl stemToFreq = new PipeImpl();
        PipeImpl freqToSink = new PipeImpl();

        pipes.add(sourceToTrim);
        pipes.add(trimToBlank);
        pipes.add(blankToAlpha);
        pipes.add(alphaToLower);
        pipes.add(lowerToStop);
        pipes.add(stopToStem);
        pipes.add(stemToFreq);
        pipes.add(freqToSink);
    }

    // helper function for getting root directory of system, mainly taken from
    // https://condor.depaul.edu/elliott/435/hw/programs/mywebserver/tips.html
    public static String getRootDirPath() {
        // getting the root file of the system the program is running in
        File dirf = new File(".");
        // set up directory root string to be returned
        String directoryRoot = "";
        try {
            // tracing the path from root file, putting it into directoryRoot
            directoryRoot = dirf.getCanonicalPath();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // return the path
        return directoryRoot;
    }

    public static void main(String[] args) throws IOException {
        String f = "";
        if (args.length > 0) {
            f = args[0];
        } else {
            System.out.println("Proper usage: java Main.java <filename.txt>");
        }

        setUpPipeLine(f);
        PipeLine pipeLine = new PipeLine(nodes, pipes);

        pipeLine.connect();
        pipeLine.execute();
    }
}
