/**
 * Pipe implementation. The pipe moves data from one node/filter to the other, this data is of the same type.
 *
 */
public class PipeImpl implements Pipe {
    FilterObj fromNode;
    FilterObj toNode;

    @Override
    public void setUpPipe(FilterObj fromNode, FilterObj toNode) {
        this.fromNode = fromNode;
        this.toNode = toNode;
    }

    public FilterObj getFromNode() {
        return fromNode;
    }

    public FilterObj getToNode() {
        return toNode;
    }

    @Override
    public void transportData() {

        toNode.setData(fromNode.getData());
    }
}
