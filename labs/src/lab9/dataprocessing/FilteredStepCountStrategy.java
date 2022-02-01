package lab9.dataprocessing;

import lab9.main.Utils;
import lab9.storage.DataRepository;
import lab9.storage.SensorData;

import java.util.concurrent.TimeUnit;

public class FilteredStepCountStrategy implements StepCountStrategy{
    DataRepository dr;
    private static final int MAX_DIFF_STEPS_CONSECUTIVE_RECORDS = 1000;
    private static final long TIME_FOR_MAX_DIFF = TimeUnit.SECONDS.toMillis(1);

    public FilteredStepCountStrategy(DataRepository dr) {
        this.dr = dr;
    }

    @Override
    public int getTotalSteps() {
        int sum = 0;

        int index = 0;
        for (SensorData sensorData : dr.getStoredData()) {
            if (sensorData.getStepsCount() > 0) {
                long diff = 999999;
                if (index > 0) {
                    diff = sensorData.getTimestamp() - dr.getStoredData().get(index - 1).getTimestamp();
                }

                if (!(sensorData.getStepsCount() > MAX_DIFF_STEPS_CONSECUTIVE_RECORDS &&
                 diff < TIME_FOR_MAX_DIFF)) {
                    sum += sensorData.getStepsCount();
                }
            }

            index++;
        }

        return sum;
    }

    @Override
    public String getStrategyDescription() {
        return Utils.FILTERED_STRATEGY;
    }
}
