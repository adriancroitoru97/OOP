package lab9.storage;

import java.util.Observable;
import java.util.Observer;

public class ConsoleLogger implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        SensorData sensorData = (SensorData) arg;
        System.out.println(sensorData);
    }
}
