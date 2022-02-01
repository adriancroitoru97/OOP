package simulator;

import database.Child;
import database.Gift;

import java.util.List;

/**
 * Class containing all the changes that occur
 * in the database in a specific year.
 */
public final class AnnualChange {
    private final Integer newSantaBudget;
    private final List<Gift> newGifts;
    private final List<Child> newChildren;
    private final List<ChildUpdate> childrenUpdates;

    public AnnualChange(final Integer newSantaBudget, final List<Gift> newGifts,
                        final List<Child> newChildren,
                        final List<ChildUpdate> childrenUpdates) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
    }

    public Integer getNewSantaBudget() {
        return newSantaBudget;
    }

    public List<Gift> getNewGifts() {
        return newGifts;
    }

    public List<Child> getNewChildren() {
        return newChildren;
    }

    public List<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }
}
