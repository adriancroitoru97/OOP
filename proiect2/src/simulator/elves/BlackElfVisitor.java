package simulator.elves;

import common.Constants;
import database.Child;

public final class BlackElfVisitor implements ChildVisitor {

    @Override
    public void visit(final Child child) {
        Double budget = child.getAssignedBudget();
        budget -= (budget * Constants.THIRTY) / Constants.HUNDRED;
        child.setAssignedBudget(budget);
    }
}
