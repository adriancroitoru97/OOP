package simulator.averageScore;

import database.Child;

import java.util.List;

public final class TeenAverageScoreStrategy implements AverageScoreStrategy {

    @Override
    public Double calculate(final Child child) {
        int index = 0;
        int indexSum = 0;
        double sum = 0.0;
        List<Double> scoreHistory = child.getNiceScoreHistory();

        for (Double current : scoreHistory) {
            index++;
            indexSum += index;
            sum += current * index;
        }

        return sum / indexSum;
    }
}
