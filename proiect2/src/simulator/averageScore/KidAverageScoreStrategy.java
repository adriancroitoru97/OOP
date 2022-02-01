package simulator.averageScore;

import database.Child;

import java.util.List;

public final class KidAverageScoreStrategy implements AverageScoreStrategy {

    @Override
    public Double calculate(final Child child) {
        double sum = 0.0;
        List<Double> scoreHistory = child.getNiceScoreHistory();

        for (Double current : scoreHistory) {
            sum += current;
        }

        return sum / scoreHistory.size();
    }
}
