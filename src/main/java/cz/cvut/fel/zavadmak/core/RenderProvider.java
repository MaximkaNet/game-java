package cz.cvut.fel.zavadmak.core;

import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

public class RenderProvider extends Canvas {
    public void fixAspectRatio(double aspectRatio) {
        Parent parent = getParent();
        if (parent instanceof Pane) {
            widthProperty().bind(((Pane) getParent()).widthProperty());
            heightProperty().bind(((Pane) getParent()).widthProperty().multiply(aspectRatio));
        }
    }
}
