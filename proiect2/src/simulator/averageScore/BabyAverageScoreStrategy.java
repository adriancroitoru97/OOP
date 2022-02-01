package simulator.averageScore;

import common.Constants;
import database.Child;

public final class BabyAverageScoreStrategy implements AverageScoreStrategy {

    @Override
    public Double calculate(final Child child) {
        return Constants.MAX_AVERAGE_SCORE;
    }
}
