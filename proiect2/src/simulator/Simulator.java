package simulator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;
import database.Child;
import database.Database;
import database.Gift;
import enums.AgeCategory;
import enums.Category;
import enums.CityStrategyEnum;
import enums.ElvesType;
import fileio.input.Input;
import fileio.output.ChildWriter;
import fileio.output.Writer;
import simulator.assignOrder.AssignOrderStrategy;
import simulator.assignOrder.AssignOrderStrategyFactory;
import simulator.averageScore.AverageScoreStrategy;
import simulator.averageScore.AverageScoreStrategyFactory;
import simulator.elves.ChildVisitor;
import simulator.elves.ChildVisitorFactory;
import simulator.elves.YellowElfVisitor;
import utils.Utils;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Comparator;
import java.util.stream.Collectors;

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
        runCurrentYear(0);
        for (int i = 0; i < numberOfYears; i++) {
            updateDatabase(annualChanges.get(i));
            runCurrentYear(i + 1);
        }
    }

    /**
     * The flow for a single year. Identical algorithm for all years.
     */
    private void runCurrentYear(final Integer year) {

        /* Remove those children with null NiceScore */
        database.getChildren().removeIf(child -> child.getNiceScore() == null);

        /* Set for every child the average score, based on its age */
        AverageScoreStrategyFactory strategyFactory = new AverageScoreStrategyFactory();
        Iterator<Child> i = database.getChildren().iterator();
        while (i.hasNext()) {
            Child child = i.next();
            AverageScoreStrategy strategy = strategyFactory.createStrategy(child);
            if (strategy != null) {
                Double averageScore = strategy.calculate(child);

                /* the NiceScoreBonus is given and the result is truncated at 10 */
                averageScore = averageScore
                        + (averageScore * child.getNiceScoreBonus()) / Constants.HUNDRED;
                if (averageScore > Constants.MAX_AVERAGE_SCORE) {
                    averageScore = Constants.MAX_AVERAGE_SCORE;
                }

                child.setAverageScore(averageScore);
            } else {
                i.remove();
            }
        }

        /* Calculate the current year's budgetUnit and set for each
           child the assigned budget for this year */
        Double budgetUnit = SimulatorUtils.budgetUnitCalculate(database);
        for (Child child : database.getChildren()) {
            double assignedBudget = child.getAverageScore() * budgetUnit;
            child.setAssignedBudget(assignedBudget);
        }

        /* Black and Pink Elves visit the children who have them assigned as elves */
        ChildVisitorFactory visitorFactory = new ChildVisitorFactory();
        for (Child child : database.getChildren()) {
            ChildVisitor elf = visitorFactory.createVisitor(child.getElf());
            if (elf != null && !child.getElf().equals(ElvesType.YELLOW)) {
                child.accept(elf);
            }
        }

        /* Clear the received gifts from past years and assign
           gifts for the current year based on
           the assignOrder specified in the input */
        for (Child child : database.getChildren()) {
            child.getReceivedGifts().clear();
        }

        if (year == 0) {
            assignGifts(CityStrategyEnum.ID);
        } else {
            assignGifts(annualChanges.get(year - 1).getStrategy());
        }

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
    private void updateDatabase(final AnnualChange annualChange) {

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

                child.setElf(childUpdate.getElf());
            }
        }

        /* New gifts are added to the database */
        for (Gift newGift : annualChange.getNewGifts()) {
            database.getGifts().add(newGift);
        }

        /* The Santa's budget is updated */
        database.setSantaBudget(annualChange.getNewSantaBudget());
    }

    /**
     * Algorithm used for assigning the gifts in a year.
     *
     * @param strategy the assign order strategy used
     */
    private void assignGifts(final CityStrategyEnum strategy) {
        List<Child> children = database.getChildren();
        List<Gift> gifts = database.getGifts();

        /* sort the children according to the gift
           assign order strategy specified in the input */
        AssignOrderStrategyFactory assignOrderStrategyFactory = new AssignOrderStrategyFactory();
        AssignOrderStrategy assignOrderStrategy
                = assignOrderStrategyFactory.createStrategy(strategy);
        List<Child> sortedChildren = assignOrderStrategy.getOrder(children);

        /* loop every child in the database */
        for (Child currentChild : sortedChildren) {
            /* the initial assigned budget of the current child */
            Double assignedBudget = currentChild.getAssignedBudget();
            currentChild.setRemainedBudget(assignedBudget);

            /* loop every preference category of the current child */
            List<Category> currentChildPreferences = currentChild.getGiftsPreferences();
            for (Category currentPreference : currentChildPreferences) {

                /* get a sorted ascending by price list of gifts in the current
                   category and with a price lower or equal with the budget */
                List<Gift> sortedFilteredGifts = gifts.stream()
                        .filter(gift -> gift.getQuantity() > 0)
                        .filter(gift -> gift.getCategory() == currentPreference)
                        .filter(gift -> gift.getPrice() <= currentChild.getRemainedBudget())
                        .sorted(Comparator.comparing(Gift::getPrice))
                        .collect(Collectors.toList());

                /* assign the cheapest (the first in the sorted list) gift and
                   update the child remained budget */
                if (!sortedFilteredGifts.isEmpty()) {
                    Gift receivedGift = sortedFilteredGifts.get(0);

                    currentChild.getReceivedGifts().add(receivedGift);
                    currentChild.setRemainedBudget(
                            currentChild.getRemainedBudget() - receivedGift.getPrice()
                    );

                    receivedGift.setQuantity(receivedGift.getQuantity() - 1);
                }
            }
        }

        /* After the assignation is done, the Yellow elf visits
           all the children who have it assigned as their elf */
        ChildVisitorFactory visitorFactory = new ChildVisitorFactory();
        for (Child child : children) {
            if (child.getElf() == ElvesType.YELLOW) {
                YellowElfVisitor elf =
                        (YellowElfVisitor) visitorFactory.createVisitor(child.getElf());
                elf.setGifts(gifts);
                child.accept(elf);
            }
        }
    }
}
