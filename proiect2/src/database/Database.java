package database;

import fileio.input.Input;
import utils.Utils;

import java.util.List;

public final class Database {

    private Integer santaBudget;
    private List<Child> children;
    private List<Gift> gifts;

    private static Database database = null;

    private Database() { }

    /**
     * Singleton pattern used for allowing the
     * existence of only one Database object.
     *
     * @return the database object
     */
    public static Database getDatabase() {
        if (database == null) {
            database = new Database();
        }

        return database;
    }

    /**
     * Sets the database fields.
     *
     * @param input the input as it is in the json input files
     *              used for loading the database
     */
    public void setDatabase(final Input input) {
        if (database != null) {
            this.santaBudget = input.getSantaBudget();
            this.children = Utils.inputListToChildList(input.getInitialData().getChildren());
            this.gifts = Utils.inputListToGiftList(input.getInitialData().getSantaGiftsList());
        }
    }

    public Integer getSantaBudget() {
        return santaBudget;
    }

    public List<Child> getChildren() {
        return children;
    }

    public List<Gift> getGifts() {
        return gifts;
    }

    public void setSantaBudget(final Integer santaBudget) {
        this.santaBudget = santaBudget;
    }

    public void setChildren(final List<Child> children) {
        this.children = children;
    }

    public void setGifts(final List<Gift> gifts) {
        this.gifts = gifts;
    }
}
