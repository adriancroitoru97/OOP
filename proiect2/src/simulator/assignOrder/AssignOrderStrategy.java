package simulator.assignOrder;

import database.Child;

import java.util.List;

/**
 * Strategy pattern used for determining a list of
 * Child objects sorted by different algorithms.
 */
public interface AssignOrderStrategy {

    /**
     * Determines the sorted list of children.
     *
     * @param children the initial list
     * @return
     *      the sorted list using a specific strategy, mentioned in the input
     */
    List<Child> getOrder(List<Child> children);
}
