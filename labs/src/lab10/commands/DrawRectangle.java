package lab10.commands;

import lab10.diagram.DiagramCanvas;
import lab10.diagram.DiagramComponent;

public class DrawRectangle implements DrawCommand {

    private final DiagramCanvas diagramCanvas;
    private DiagramComponent prevComponent;

    public DrawRectangle(DiagramCanvas diagramCanvas) {
        this.diagramCanvas = diagramCanvas;
    }

    @Override
    public void execute() {
        DiagramComponent diagramComponent = new DiagramComponent();
        diagramCanvas.addComponent(diagramComponent);
        prevComponent = diagramComponent;
    }

    @Override
    public void undo() {
        diagramCanvas.removeComponent(prevComponent);
    }

    @Override
    public String toString() {
        return "DrawRectangle{" +
                "diagramCanvas=" + diagramCanvas +
                '}';
    }
}
