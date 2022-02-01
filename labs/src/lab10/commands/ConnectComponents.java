package lab10.commands;

import lab10.diagram.DiagramCanvas;
import lab10.diagram.DiagramComponent;

public class ConnectComponents implements DrawCommand {

    private final DiagramCanvas diagramCanvas;
    private final String index1;
    private final String index2;

    public ConnectComponents(DiagramCanvas diagramCanvas, String index1, String index2) {
        this.diagramCanvas = diagramCanvas;
        this.index1 = index1;
        this.index2 = index2;
    }

    @Override
    public void execute() {
        DiagramComponent diagramComponent1 = diagramCanvas.getComponent(Integer.parseInt(index1));
        DiagramComponent diagramComponent2 = diagramCanvas.getComponent(Integer.parseInt(index2));

        diagramComponent1.connectTo(index2);
        diagramComponent2.connectTo(index1);
    }

    @Override
    public void undo() {
        DiagramComponent diagramComponent1 = diagramCanvas.getComponent(Integer.parseInt(index1));
        DiagramComponent diagramComponent2 = diagramCanvas.getComponent(Integer.parseInt(index2));

        diagramComponent1.removeConnection(index2);
        diagramComponent2.removeConnection(index1);
    }

    @Override
    public String toString() {
        return "ConnectComponents{" +
                "diagramCanvas=" + diagramCanvas +
                ", index1='" + index1 + '\'' +
                ", index2='" + index2 + '\'' +
                '}';
    }
}
