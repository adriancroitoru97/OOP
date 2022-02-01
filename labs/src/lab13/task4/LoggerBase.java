package lab13.task4;

import java.util.EnumSet;

public abstract class LoggerBase {

    EnumSet<LogLevel> levels;
    LoggerBase next;

    public LoggerBase(EnumSet<LogLevel> levels) {
        this.levels = levels;
    }

    public void setNext(LoggerBase next) {
        this.next = next;
    }

    protected abstract void writeMessage(String message);

    public void message(String message, LogLevel severity) {
        if (levels.contains(severity)) {
            writeMessage(message);
        }

        if (next != null) {
            next.message(message, severity);
        }
    }
}
