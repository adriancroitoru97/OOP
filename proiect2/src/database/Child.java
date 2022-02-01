package database;

import enums.Category;
import enums.Cities;
import enums.ElvesType;
import simulator.elves.ChildVisitor;

import java.util.ArrayList;

public final class Child {

    private final Integer id;
    private final String lastName;
    private final String firstName;
    private Integer age;
    private final Cities city;
    private final Double niceScore;
    private final ArrayList<Category> giftsPreferences;
    private ElvesType elf;
    private final Integer niceScoreBonus;

    private Double averageScore;
    private Double assignedBudget;
    private Double remainedBudget;
    private final ArrayList<Gift> receivedGifts;
    private final ArrayList<Double> niceScoreHistory;

    /**
     * Builder pattern used for the Child object instantiation and configuration.
     */
    public static final class Builder {

        /* mandatory fields */
        private final Integer id;
        private final String lastName;
        private final String firstName;
        private final Integer age;
        private final Cities city;
        private final Double niceScore;
        private final ArrayList<Category> giftsPreferences;
        private final ElvesType elf;

        /* optional field */
        private Integer niceScoreBonus;

        public Builder(final Integer id, final String lastName, final String firstName,
                       final Integer age, final Cities city, final Double niceScore,
                       final ArrayList<Category> giftsPreferences, final ElvesType elf) {
            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.age = age;
            this.city = city;
            this.niceScore = niceScore;
            this.giftsPreferences = giftsPreferences;
            this.elf = elf;
        }

        /**
         * Builder pattern method used to set the optional field niceScoreBonus
         *
         * @param scoreBonus
         *      the niceScoreBonus given in the input
         * @return
         *      the Builder object used for the instantiation of the Child object
         */
        public Builder niceScoreBonus(final Integer scoreBonus) {
            this.niceScoreBonus = scoreBonus;
            return this;
        }

        /**
         * Method used to build the Child object from the previous
         * created Builder object.
         *
         * @return the Child object
         */
        public Child build() {
            return new Child(this);
        }
    }

    private Child(final Builder builder) {
        this.id = builder.id;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.age = builder.age;
        this.city = builder.city;
        this.niceScore = builder.niceScore;
        this.giftsPreferences = builder.giftsPreferences;
        this.elf = builder.elf;
        this.niceScoreBonus = builder.niceScoreBonus;

        this.receivedGifts = new ArrayList<>();
        this.niceScoreHistory = new ArrayList<>();
        this.niceScoreHistory.add(niceScore);
    }

    /**
     * Method used by the Visitor pattern.
     * Represents the capability of a Child object to accept a Visitor.
     *
     * @param v the visitor (an elf)
     */
    public void accept(final ChildVisitor v) {
        v.visit(this);
    }


    /**
     *  Getters and Setters
     */
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

    public Integer getNiceScoreBonus() {
        return niceScoreBonus;
    }

    public ElvesType getElf() {
        return elf;
    }

    public void setElf(final ElvesType elf) {
        this.elf = elf;
    }

    public Double getRemainedBudget() {
        return remainedBudget;
    }

    public void setRemainedBudget(final Double remainedBudget) {
        this.remainedBudget = remainedBudget;
    }
}
