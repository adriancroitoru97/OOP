package simulator.assignOrder;

import enums.CityStrategyEnum;

/**
 * Factory pattern used for creating the corresponding
 * order strategy for the list of children.
 */
public final class AssignOrderStrategyFactory {

    /**
     * Creates the right AssignOrderStrategy object depending on
     * the strategy given as parameter.
     *
     * @param strategy
     *      the strategy as given in the input for the current simulation
     * @return the effective strategy object
     */
    public AssignOrderStrategy createStrategy(final CityStrategyEnum strategy) {

        return switch (strategy) {
            case ID -> new IdStrategy();
            case NICE_SCORE -> new NiceScoreStrategy();
            case NICE_SCORE_CITY -> new NiceScoreCityStrategy();
        };
    }
}
