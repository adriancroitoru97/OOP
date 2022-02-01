package lab13.task4;

import java.util.EnumSet;

public class FileLogger extends LoggerBase{

    public FileLogger() {
        super(EnumSet.of(LogLevel.Warning, LogLevel.Error));
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("[File]" + message);
    }
}
