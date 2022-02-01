package lab9.storage;

import lab9.communication.ServerMessage;
import lab9.main.Utils;

import java.util.Observable;
import java.util.Observer;

public class ServerCommunicationController implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        SensorData sensorData = (SensorData) arg;
        ServerMessage serverMessage =
                new ServerMessage(sensorData.getStepsCount(), Utils.getClientId(), sensorData.getTimestamp());
        System.out.println(serverMessage);
    }
}
