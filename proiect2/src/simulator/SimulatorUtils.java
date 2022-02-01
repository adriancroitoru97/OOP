package simulator;

import common.Constants;
import database.Child;
import database.Database;
import enums.AgeCategory;

public final class SimulatorUtils {

    private SimulatorUtils() {
    }

    /**
     * Calculates the age category for a child, depending on its age.
     *
     * @param child the child
     * @return an enum entry, according to the child's age
     */
    public static AgeCategory getAgeCategory(final Child child) {
        AgeCategory childAgeCategory;

        if (child.getAge() < Constants.BABY) {
            childAgeCategory = AgeCategory.BABY;
        } else if (child.getAge() < Constants.KID) {
            childAgeCategory = AgeCategory.KID;
        } else if (child.getAge() <= Constants.TEEN) {
            childAgeCategory = AgeCategory.TEEN;
        } else {
            childAgeCategory = AgeCategory.YOUNG_ADULT;
        }

        return childAgeCategory;
    }

    /**
     * Calculates the Santa's budget unit for the current year.
     *
     * @param database the Santa's database updated with current year's data
     * @return the budget unit
     */
    public static Double budgetUnitCalculate(final Database database) {
        double sum = 0.0;

        for (Child child : database.getChildren()) {
            sum += child.getAverageScore();
        }

        return database.getSantaBudget() / sum;
    }

    /**
     * Returns the child with the id given as parameter.
     *
     * @param database the database
     * @param id the id of the wanted child
     * @return the child
     */
    public static Child getChildById(final Database database, final Integer id) {
        for (Child child : database.getChildren()) {
            if (child.getId().equals(id)) {
                return child;
            }
        }

        return null;
    }
}
