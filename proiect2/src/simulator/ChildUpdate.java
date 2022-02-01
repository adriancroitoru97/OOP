package simulator;

import enums.Category;
import enums.ElvesType;

import java.util.List;

/**
 * Class containing the updates that occur in a child in a specific year.
 */
public final class ChildUpdate {
    private final Integer id;
    private final Double niceScore;
    private final List<Category> giftsPreferences;

    private final ElvesType elf;

    public ChildUpdate(final Integer id, final Double niceScore,
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
