package fileio.input;

import enums.Category;
import enums.Cities;
import enums.ElvesType;

import java.util.ArrayList;

public final class ChildInputData {

    private final Integer id;
    private final String lastName;
    private final String firstName;
    private final Integer age;
    private final Cities city;
    private final Double niceScore;
    private final ArrayList<Category> giftsPreferences;

    private final Integer niceScoreBonus;
    private final ElvesType elf;

    public ChildInputData() {
        this.id = null;
        this.lastName = null;
        this.firstName = null;
        this.age = null;
        this.city = null;
        this.niceScore = null;
        this.giftsPreferences = null;
        this.niceScoreBonus = null;
        this.elf = null;
    }

    public ChildInputData(final int id, final String lastName, final String firstName,
                          final int age, final Cities city, final double niceScore,
                          final ArrayList<Category> giftsPreference,
                          final int niceScoreBonus, final ElvesType elf) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreference;
        this.niceScoreBonus = niceScoreBonus;
        this.elf = elf;
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getAge() {
        return age;
    }

    public Cities getCity() {
        return city;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public Integer getNiceScoreBonus() {
        return niceScoreBonus;
    }

    public ElvesType getElf() {
        return elf;
    }
}
