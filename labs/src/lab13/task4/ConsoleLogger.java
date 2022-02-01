package lab13.task4;

import java.util.EnumSet;

public class ConsoleLogger extends LoggerBase{

    public ConsoleLogger() {
        super(LogLevel.all());
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("[Console]" + message);
    }
}
