import java.io.IOException;
import java.util.ArrayList;

/**
 * the filter interface, where data that is put into it from a pipe is
 * then processed and transformed, and then ready for the subsequent pipe to pull it.
 */

public interface Filter{
    public void transformData() throws IOException;
}
