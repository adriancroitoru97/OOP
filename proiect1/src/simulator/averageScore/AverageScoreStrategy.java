package simulator.averageScore;

import database.Child;

/**
 * Strategy design pattern used for calculating
 * the average score of a child depending on its age.
 */
public interface AverageScoreStrategy {
    /**
     * Calculates the average score of a child
     *
     * @param child the child
     * @return the result based on different strategies, depending on the
     *          age of the child
     */
    Double calculate(Child child);
}
