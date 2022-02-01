package database;

import enums.Category;
import enums.Cities;

import java.util.ArrayList;

public final class Child {

    private final Integer id;
    private final String lastName;
    private final String firstName;
    private Integer age;
    private final Cities city;
    private final Double niceScore;
    private final ArrayList<Category> giftsPreferences;

    private final ArrayList<Double> niceScoreHistory;
    private Double averageScore;
    private Double assignedBudget;
    private final ArrayList<Gift> receivedGifts;

    public Child(final Integer id, final String lastName, final String firstName,
                 final Integer age, final Cities city, final Double niceScore,
                 final ArrayList<Category> giftsPreferences) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;

        this.niceScoreHistory = new ArrayList<>();
        this.niceScoreHistory.add(niceScore);

        this.averageScore = null;

        this.receivedGifts = new ArrayList<>();
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

    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }
}
