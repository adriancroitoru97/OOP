package simulator;

import database.Child;
import database.Gift;
import enums.CityStrategyEnum;

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

    private final CityStrategyEnum strategy;

    public AnnualChange(final Integer newSantaBudget, final List<Gift> newGifts,
                        final List<Child> newChildren,
                        final List<ChildUpdate> childrenUpdates,
                        final CityStrategyEnum strategy) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;

        this.strategy = strategy;
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

    public CityStrategyEnum getStrategy() {
        return strategy;
    }
}
