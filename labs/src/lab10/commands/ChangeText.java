package lab10.commands;

import lab10.diagram.DiagramCanvas;
import lab10.diagram.DiagramComponent;

public class ChangeText implements DrawCommand {

    private final DiagramCanvas diagramCanvas;
    private final int index;
    private String newText;
    private String prevText;

    public ChangeText(DiagramCanvas diagramCanvas, String index, String newText) {
        this.diagramCanvas = diagramCanvas;
        this.index = Integer.parseInt(index);
        this.newText = newText;
    }

    @Override
    public void execute() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(index);
        prevText = diagramComponent.getText();
        diagramComponent.setText(newText);
    }

    @Override
    public void undo() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(index);
        newText = prevText;
        prevText = diagramComponent.getText();
        diagramComponent.setText(newText);

        newText = prevText;
    }

    @Override
    public String toString() {
        return "ChangeText{" +
                "diagramCanvas=" + diagramCanvas +
                ", index=" + index +
                ", newText='" + newText + '\'' +
                '}';
    }
}
