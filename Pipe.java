import java.util.ArrayList;

/** Pipe interface, utilizes the passive pipe and filter architecture style and so does
 * the work of moving data down the pipeline
 *
 **/

public interface Pipe {
   public void transportData();
   public void setUpPipe(FilterObj fromNode, FilterObj toNode);
}
