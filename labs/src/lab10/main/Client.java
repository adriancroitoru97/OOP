package lab10.main;

import lab10.commands.*;
import lab10.diagram.DiagramCanvas;

/**
 * Receives commands in clear text from the user and transforms them in DrawCommand objects. It uses the Invoker to
 * execute the given commands.
 */
public class Client {

    private Invoker invoker;
    private DiagramCanvas diagramCanvas;

    Client() {
        invoker = new Invoker();
        diagramCanvas = new DiagramCanvas();
    }

    public void showDiagram() {
        // TODO
        diagramCanvas.show();
    }

    public void newDiagram() {
        // TODO
        invoker.restart();
        diagramCanvas = new DiagramCanvas();
    }

    public void executeAction(String commandName, String ...args) {
        // TODO - uncomment:
        DrawCommand command;
        try {
            CommandType commandType = CommandType.fromString(commandName);
            command = getCommand(commandType, args);
            if (command == null) {
                throw new IllegalArgumentException();
            }

        } catch(IllegalArgumentException ex) {
            System.out.println("Invalid command: " + commandName);
            System.out.println("Available commands:");
            for (CommandType type : CommandType.values()) {
                System.out.println("\t- " + type.text);
            }
            return;
        }

        // TODO - Execute the action
        invoker.execute(command);
    }

    private DrawCommand getCommand(CommandType type, String ...args) throws IllegalArgumentException {
        // TODO factory method to create DrawCommand subclasses.
        // If there is an exception when parsing the string arguments (NumberFormatException) catch it and
        // throw an IllegalArgumentException

        DrawCommand drawCommand = null;

        try {
            if (type == CommandType.DRAW_RECTANGLE) {
                drawCommand = new DrawRectangle(diagramCanvas);
            } else if (type == CommandType.CHANGE_COLOR) {
                drawCommand = new ChangeColor(diagramCanvas, args[0], args[1]);
            } else if (type == CommandType.CONNECT) {
                drawCommand = new ConnectComponents(diagramCanvas, args[0], args[1]);
            } else if (type == CommandType.CHANGE_TEXT) {
                drawCommand = new ChangeText(diagramCanvas, args[0], args[1]);
            } else if (type == CommandType.RESIZE) {
                drawCommand = new Resize(diagramCanvas, args[0], args[1]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Argumente invalide!");
        }

        return drawCommand;
    }

    public void undo(){
        // TODO
        invoker.undo();
    }

    public void redo() {
        // TODO
        invoker.redo();
    }
}
