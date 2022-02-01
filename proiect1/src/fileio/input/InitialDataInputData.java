package fileio.input;

import java.util.List;

public final class InitialDataInputData {
    private final List<ChildInputData> children;
    private final List<GiftInputData> santaGiftsList;

    public InitialDataInputData() {
        this.children = null;
        this.santaGiftsList = null;
    }

    public InitialDataInputData(final List<ChildInputData> children,
                                final List<GiftInputData> gifts) {
        this.children = children;
        this.santaGiftsList = gifts;
    }

    public List<ChildInputData> getChildren() {
        return children;
    }

    public List<GiftInputData> getSantaGiftsList() {
        return santaGiftsList;
    }
}
