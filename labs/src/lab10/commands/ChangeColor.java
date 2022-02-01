package lab10.commands;

import lab10.diagram.DiagramCanvas;
import lab10.diagram.DiagramComponent;

public class ChangeColor implements DrawCommand {

    private final DiagramCanvas diagramCanvas;
    private final int index;
    private String newColor;
    private String prevColor;

    public ChangeColor(DiagramCanvas diagramCanvas, String index, String newColor) {
        this.diagramCanvas = diagramCanvas;
        this.index = Integer.parseInt(index);
        this.newColor = newColor;
    }

    @Override
    public void execute() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(index);
        prevColor = diagramComponent.getColor();
        diagramComponent.setColor(newColor);
    }

    @Override
    public void undo() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(index);
        newColor = prevColor;
        prevColor = diagramComponent.getColor();
        diagramComponent.setColor(newColor);

        newColor = prevColor;
    }

    @Override
    public String toString() {
        return "ChangeColor{" +
                "diagramCanvas=" + diagramCanvas +
                ", index=" + index +
                ", newColor='" + newColor + '\'' +
                '}';
    }
}
