package simulator.averageScore;

import common.Constants;
import database.Child;

/**
 * Factory design pattern used for generating the corresponding
 * average score strategy for a child.
 */
public final class AverageScoreStrategyFactory {

    /**
     * Finds the right average score strategy for a child,
     * depending on its age.
     *
     * @param child the child
     * @return the right average score strategy for the given child
     */
    public AverageScoreStrategy createStrategy(final Child child) {
        AverageScoreStrategy strategy = null;

        if (child.getAge() < Constants.BABY) {
            strategy = new BabyAverageScoreStrategy();
        } else if (child.getAge() < Constants.KID) {
            strategy = new KidAverageScoreStrategy();
        } else if (child.getAge() <= Constants.TEEN) {
            strategy = new TeenAverageScoreStrategy();
        }

        return strategy;
    }
}
