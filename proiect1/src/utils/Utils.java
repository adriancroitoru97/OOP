package utils;

import database.Child;
import database.Gift;
import fileio.input.AnnualChangeInputData;
import fileio.input.ChildInputData;
import fileio.input.ChildUpdateInputData;
import fileio.input.GiftInputData;
import simulator.AnnualChange;
import simulator.ChildUpdate;

import java.util.ArrayList;
import java.util.List;

public final class Utils {

    private Utils() {
    }

    /**
     * Converts a input children list into a Child list.
     *
     * @param childrenInput the list of children,
     *                      as it stands in the json input files
     * @return the Child effective list
     */
    public static List<Child> inputListToChildList(final List<ChildInputData> childrenInput) {
        List<Child> children = new ArrayList<>();
        for (ChildInputData child : childrenInput) {
            Child newChild = new Child(
                    child.getId(), child.getLastName(), child.getFirstName(),
                    child.getAge(), child.getCity(), child.getNiceScore(),
                    child.getGiftsPreferences()
            );
            children.add(newChild);
        }

        return children;
    }

    /**
     * Converts a input gift list into a Gift list.
     *
     * @param giftsInput the list of gifts,
     *                   as it stands in the json input files
     * @return the Gift effective list
     */
    public static List<Gift> inputListToGiftList(final List<GiftInputData> giftsInput) {
        List<Gift> gifts = new ArrayList<>();

        for (GiftInputData gift : giftsInput) {
            Gift newGift = new Gift(
                    gift.getProductName(), gift.getPrice(), gift.getCategory()
            );
            gifts.add(newGift);
        }

        return gifts;
    }

    /**
     * Converts a input child update list into a ChildUpdate list.
     *
     * @param updatesInput the list of child updates,
     *                     as it stands in the json input files
     * @return the ChildUpdate effective list
     */
    public static List<ChildUpdate> inputListToChildUpdateList(
            final List<ChildUpdateInputData> updatesInput) {
        List<ChildUpdate> updates = new ArrayList<>();

        for (ChildUpdateInputData update : updatesInput) {
            ChildUpdate newUpdate = new ChildUpdate(
                update.getId(), update.getNiceScore(),
                    update.getGiftsPreferences()
            );
            updates.add(newUpdate);
        }

        return updates;
    }

    /**
     * Converts a input annual change list into a AnnualChange list.
     *
     * @param annualChangesInput the list of annual changes,
     *                           as it stands in the json input files
     * @return the AnnualChanges effective list
     */
    public static List<AnnualChange> inputListToAnnualChangeList(
            final List<AnnualChangeInputData> annualChangesInput) {
        List<AnnualChange> annualChanges = new ArrayList<>();

        for (AnnualChangeInputData annualChange : annualChangesInput) {
            AnnualChange newChange = new AnnualChange(
                    annualChange.getNewSantaBudget(),
                    Utils.inputListToGiftList(annualChange.getNewGifts()),
                    Utils.inputListToChildList(annualChange.getNewChildren()),
                    Utils.inputListToChildUpdateList(annualChange.getChildrenUpdates())
            );

            annualChanges.add(newChange);
        }

        return annualChanges;
    }
}
