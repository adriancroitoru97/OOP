package lab10.main;

import lab10.commands.*;

import java.util.LinkedList;

/**
 * The layer between the client and the commands that need to be executed on the receivers (DiagramCanvas and DiagramComponent).
 * <br>
 * It is independent of the subtypes of commands, it just receives a command, runs it and implements a redo/undo mechanism.
 */
public class Invoker {

    private LinkedList<DrawCommand> history = new LinkedList<>();
    private LinkedList<DrawCommand> undoHistory = new LinkedList<>();

    /**
     * Clear up all the used resources, start fresh :D
     */
    public void restart() {
      // TODO
        history.clear();
        undoHistory.clear();
    }

    /**
     * Executes a given command
     * @param command
     */
    public void execute(DrawCommand command) {
        history.push(command);
        undoHistory.clear();
        command.execute();
    }

    /**
     * Undo the latest command
     */
    public void undo() {
        // TODO
        // Hint: use data structures to keep track of commands
        // Do not use the java.util.Stack, its implementation is based on vector which is inefficient and deprecated.
        // Use a class that implements the Deque interface, e.g. LinkedList https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Deque.html

        if (!history.isEmpty()) {
            DrawCommand command = history.pop();
            if (command != null) {
                undoHistory.push(command);
                command.undo();
            }
        }
    }

    /**
     * Redo command previously undone. Cannot perform a redo after an execute, only after at least one undo.
     */
    public void redo() {
        // TODO
        if (!undoHistory.isEmpty()) {
            DrawCommand command = undoHistory.pop();
            if (command != null) {
                history.push(command);
                command.execute();
            }
        }
    }
}
