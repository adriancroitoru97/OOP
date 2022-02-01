package fileio.input;

import enums.CityStrategyEnum;

import java.util.List;

public final class AnnualChangeInputData {
    private final Integer newSantaBudget;
    private final List<GiftInputData> newGifts;
    private final List<ChildInputData> newChildren;
    private final List<ChildUpdateInputData> childrenUpdates;

    private final CityStrategyEnum strategy;

    public AnnualChangeInputData() {
        this.newSantaBudget = null;
        this.newGifts = null;
        this.newChildren = null;
        this.childrenUpdates = null;

        this.strategy = null;
    }

    public AnnualChangeInputData(final Integer newSantaBudget,
                                 final List<GiftInputData> newGifts,
                                 final List<ChildInputData> newChildren,
                                 final List<ChildUpdateInputData> childrenUpdates,
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

    public List<GiftInputData> getNewGifts() {
        return newGifts;
    }

    public List<ChildInputData> getNewChildren() {
        return newChildren;
    }

    public List<ChildUpdateInputData> getChildrenUpdates() {
        return childrenUpdates;
    }

    public CityStrategyEnum getStrategy() {
        return strategy;
    }
}
