package fileio.input;

import enums.Category;

import java.util.List;

public final class ChildUpdateInputData {
    private final Integer id;
    private final Double niceScore;
    private final List<Category> giftsPreferences;

    public ChildUpdateInputData() {
        this.id = null;
        this.niceScore = null;
        this.giftsPreferences = null;
    }

    public ChildUpdateInputData(final Integer id, final Double niceScore,
                                final List<Category> giftsPreferences) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
    }

    public Integer getId() {
        return id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }
}
