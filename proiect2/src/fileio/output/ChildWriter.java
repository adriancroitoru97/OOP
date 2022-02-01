package fileio.output;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used for track down the result of the current year simulation.
 * It contains a list of JsonNode objects - the list
 * of children of the current year.
 */
public final class ChildWriter {
    private final List<JsonNode> children;

    public ChildWriter() {
        this.children = new ArrayList<>();
    }

    public List<JsonNode> getChildren() {
        return children;
    }
}
