package fileio.input;

import enums.Category;
import enums.ElvesType;

import java.util.List;

public final class ChildUpdateInputData {
    private final Integer id;
    private final Double niceScore;
    private final List<Category> giftsPreferences;

    private final ElvesType elf;

    public ChildUpdateInputData() {
        this.id = null;
        this.niceScore = null;
        this.giftsPreferences = null;
        this.elf = null;
    }

    public ChildUpdateInputData(final Integer id, final Double niceScore,
                                final List<Category> giftsPreferences,
                                final ElvesType elf) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;

        this.elf = elf;
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

    public ElvesType getElf() {
        return elf;
    }
}
