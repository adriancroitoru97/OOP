package simulator;

import common.Constants;
import database.Child;
import database.Database;
import database.Gift;
import enums.AgeCategory;
import enums.Category;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Child> sortedChildren = sortChildrenById(database.getChildren());

        for (Child child :sortedChildren) {
            sum += child.getAverageScore();
        }

        return database.getSantaBudget() / sum;
    }

    /**
     * Algorithm used for assigning the gifts in a year.
     *
     * @param database the Santa's database updated with current year's data
     */
    public static void assignGifts(final Database database) {
        List<Child> children = database.getChildren();
        List<Gift> gifts = database.getGifts();

        /* loop every child in the database */
        for (Child currentChild : children) {
            /* the initial assigned budget of the current child */
            Double assignedBudget = currentChild.getAssignedBudget();

            /* loop every preference category of the current child */
            List<Category> currentChildPreferences = currentChild.getGiftsPreferences();
            for (Category currentPreference : currentChildPreferences) {

                /* get a sorted ascending by price list of gifts in the current
                   category and with a price lower or equal with the budget */
                List<Gift> sortedFilteredGifts = gifts.stream()
                        .filter(gift -> gift.getCategory() == currentPreference)
                        .filter(gift -> gift.getPrice() <= currentChild.getAssignedBudget())
                        .sorted(Comparator.comparing(Gift::getPrice))
                        .collect(Collectors.toList());

                /* assign the cheapest (the first in the sorted list) gift and
                   update the child remained budget */
                if (!sortedFilteredGifts.isEmpty()) {
                    Gift receivedGift = sortedFilteredGifts.get(0);
                    currentChild.getReceivedGifts().add(receivedGift);
                    currentChild.setAssignedBudget(
                            currentChild.getAssignedBudget() - receivedGift.getPrice()
                    );
                }
            }

            /* restore the initial child budget, needed in the output */
            currentChild.setAssignedBudget(assignedBudget);
        }
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

    /**
     * Sorts a list of Child objects ascending based on their id.
     *
     * @param children a list of Child objects
     * @return the sorted list
     */
    public static List<Child> sortChildrenById(final List<Child> children) {
        List<Child> sortedChildren;
        sortedChildren = children
                .stream()
                .sorted(Comparator.comparing(Child::getId))
                .collect(Collectors.toList());

        return sortedChildren;
    }
}
