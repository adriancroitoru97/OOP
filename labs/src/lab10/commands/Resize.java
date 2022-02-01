package lab10.commands;

import lab10.diagram.DiagramCanvas;
import lab10.diagram.DiagramComponent;

public class Resize implements DrawCommand {

    private final DiagramCanvas diagramCanvas;
    private final int index;
    private final double percentage;

    private int newHeight;
    private int newWeight;
    private int prevHeight;
    private int prevWeight;

    public Resize(DiagramCanvas diagramCanvas, String index, String percentage) {
        this.diagramCanvas = diagramCanvas;
        this.index = Integer.parseInt(index);
        this.percentage = Double.parseDouble(percentage);
    }

    @Override
    public void execute() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(index);

        prevHeight = diagramComponent.getHeight();
        newHeight = (int) (diagramComponent.getHeight() * (percentage / 100));
        diagramComponent.setHeight(newHeight);

        prevWeight = diagramComponent.getWeight();
        newWeight = (int) (diagramComponent.getWeight() * (percentage / 100));
        diagramComponent.setWeight(newWeight);
    }

    @Override
    public void undo() {
        DiagramComponent diagramComponent = diagramCanvas.getComponent(index);

        newHeight = prevHeight;
        prevHeight = diagramComponent.getHeight();
        diagramComponent.setHeight(newHeight);

        newWeight = prevWeight;
        prevWeight = diagramComponent.getWeight();
        diagramComponent.setWeight(newWeight);
    }

    @Override
    public String toString() {
        return "Resize{" +
                "diagramCanvas=" + diagramCanvas +
                ", index=" + index +
                ", percentage=" + percentage +
                '}';
    }
}
