package simulator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import database.Child;
import database.Database;
import database.Gift;
import enums.AgeCategory;
import enums.Category;
import fileio.input.Input;
import fileio.output.ChildWriter;
import fileio.output.Writer;

import simulator.averageScore.AverageScoreStrategy;
import simulator.averageScore.AverageScoreStrategyFactory;
import utils.Utils;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Class used for the effective simulation of the program's flow
 */
public final class Simulator {

    private Database database;
    private Integer numberOfYears;
    private List<AnnualChange> annualChanges;

    private Writer writer;
    private ObjectMapper objectMapper;

    private static Simulator simulator = null;

    private Simulator() { }

    /**
     * Singleton pattern used for allowing the
     * existence of only one Simulator object.
     *
     * @return the simulator object
     */
    public static Simulator getSimulator() {
        if (simulator == null) {
            simulator = new Simulator();
        }

        return simulator;
    }

    /**
     * Sets the simulator required data fields.
     *
     * @param db the initial database
     * @param input the input received from a json file
     * @param writerObj contains a list of all years simulations
     * @param objMapper used by the Jackson lib for writing the output
     */
    public void setSimulator(final Database db, final Input input,
                             final Writer writerObj, final ObjectMapper objMapper) {
        this.database = db;
        this.numberOfYears = input.getNumberOfYears();
        this.annualChanges = Utils.inputListToAnnualChangeList(input.getAnnualChanges());

        this.writer = writerObj;
        this.objectMapper = objMapper;
    }

    /**
     * The effective simulation. It firstly runs the current year.
     * Then, for each year, it updates the database and runs the same algorithm.
     * (the flow is identical for all years, only the data changes)
     */
    public void run() {
        runCurrentYear();
        for (int i = 0; i < numberOfYears; i++) {
            updateDatabase(annualChanges.get(i));
            runCurrentYear();
        }
    }

    /**
     * The flow for a single year. Identical algorithm for all years.
     */
    public void runCurrentYear() {

        /* Remove those children with null NiceScore */
        database.getChildren().removeIf(child -> child.getNiceScore() == null);

        /* Set for every child the average score, based on its age */
        AverageScoreStrategyFactory strategyFactory = new AverageScoreStrategyFactory();
        Iterator<Child> i = database.getChildren().iterator();
        while (i.hasNext()) {
            Child child = i.next();
            AverageScoreStrategy strategy = strategyFactory.createStrategy(child);
            if (strategy != null) {
                child.setAverageScore(strategy.calculate(child));
            } else {
                i.remove();
            }
        }

        /* Calculate the current year's budgetUnit and set for each
           child the assigned budget for this year */
        Double budgetUnit = SimulatorUtils.budgetUnitCalculate(database);
        for (Child child : database.getChildren()) {
            child.setAssignedBudget(child.getAverageScore() * budgetUnit);
        }

        /* Clear the received gifts from past years and assign
           gifts for the current year */
        for (Child child : database.getChildren()) {
            child.getReceivedGifts().clear();
        }
        SimulatorUtils.assignGifts(database);

        /* Write the current year results in the writer object */
        ChildWriter childWriter = new ChildWriter();
        for (Child child : database.getChildren()) {
            JsonNode a = objectMapper.valueToTree(child);
            childWriter.getChildren().add(a);
        }
        writer.getAnnualChildren().add(childWriter);
    }

    /**
     * Updates the database each year, accordingly to the input file.
     * The children who become adults are deleted from the database.
     *
     * @param annualChange the database's changes for each year
     */
    public void updateDatabase(final AnnualChange annualChange) {

        /* The age of all children is incremented and the adults are
           deleted from the database */
        Iterator<Child> i = database.getChildren().iterator();
        while (i.hasNext()) {
            Child child = i.next();
            child.setAge(child.getAge() + 1);

            AgeCategory childAgeCategory = SimulatorUtils.getAgeCategory(child);
            if (childAgeCategory == AgeCategory.YOUNG_ADULT) {
                i.remove();
            }
        }

        /* New children are added into the database */
        List<Child> currentYearNewChildren = annualChange.getNewChildren();
        for (Child child : currentYearNewChildren) {
            AgeCategory childAgeCategory = SimulatorUtils.getAgeCategory(child);
            if (childAgeCategory != AgeCategory.YOUNG_ADULT) {
                database.getChildren().add(child);
            }
        }

        /* The current children data is updated according to the annual change */
        for (ChildUpdate childUpdate : annualChange.getChildrenUpdates()) {
            Child child = SimulatorUtils.getChildById(database, childUpdate.getId());

            if (child != null) {
                if (childUpdate.getNiceScore() != null) {
                    child.getNiceScoreHistory().add(childUpdate.getNiceScore());
                }

                if (!childUpdate.getGiftsPreferences().isEmpty()) {
                    Set<Category> newGiftPreferencesSet =
                            new LinkedHashSet<>(childUpdate.getGiftsPreferences());
                    newGiftPreferencesSet.addAll(child.getGiftsPreferences());

                    child.getGiftsPreferences().clear();
                    child.getGiftsPreferences().addAll(newGiftPreferencesSet);
                }
            }
        }

        /* New gifts are added to the database */
        for (Gift newGift : annualChange.getNewGifts()) {
            database.getGifts().add(newGift);
        }

        /* The Santa's budget is updated */
        database.setSantaBudget(annualChange.getNewSantaBudget());
    }
}
