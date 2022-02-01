package simulator.assignOrder;

import database.Child;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class IdStrategy implements AssignOrderStrategy {

    @Override
    public List<Child> getOrder(final List<Child> children) {
        return children
                .stream()
                .sorted(Comparator.comparing(Child::getId))
                .collect(Collectors.toList());
    }
}
