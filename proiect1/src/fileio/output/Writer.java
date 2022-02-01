package fileio.output;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used for track down the final result of a test.
 * It contains a list of ChildWriter objects.
 */
public final class Writer {
    private final List<ChildWriter> annualChildren;

    public Writer() {
        this.annualChildren = new ArrayList<>();
    }

    public List<ChildWriter> getAnnualChildren() {
        return annualChildren;
    }
}
