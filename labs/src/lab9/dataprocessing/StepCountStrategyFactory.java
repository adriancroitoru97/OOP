package lab9.dataprocessing;

import lab9.main.Utils;
import lab9.storage.DataRepository;

public class StepCountStrategyFactory {
    public StepCountStrategy createStrategy(String strategyType, DataRepository dataRepository) {
        StepCountStrategy strategy = null;

        if (strategyType.equals(Utils.BASIC_STRATEGY)) {
            strategy = new BasicStepCountStrategy(dataRepository);
        } else if (strategyType.equals(Utils.FILTERED_STRATEGY)) {
            strategy = new FilteredStepCountStrategy(dataRepository);
        }

        return strategy;
    }
}
