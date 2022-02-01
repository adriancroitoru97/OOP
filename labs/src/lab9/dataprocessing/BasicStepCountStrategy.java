package lab9.dataprocessing;

import lab9.main.Utils;
import lab9.storage.DataRepository;
import lab9.storage.SensorData;

public class BasicStepCountStrategy implements StepCountStrategy {
    DataRepository dr;

    public BasicStepCountStrategy(DataRepository dr) {
        this.dr = dr;
    }

    @Override
    public int getTotalSteps() {
        int sum = 0;
        for (SensorData sensorData : dr.getStoredData()) {
            sum += sensorData.getStepsCount();
        }

        return sum;
    }

    @Override
    public String getStrategyDescription() {
        return Utils.BASIC_STRATEGY;
    }
}
