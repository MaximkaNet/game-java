package cz.cvut.fel.zavadmak.engine;

import cz.cvut.fel.zavadmak.engine.utils.Vector;
import javafx.scene.canvas.GraphicsContext;

public abstract class Camera {
    /**
     * The game object name
     */
    private final String name;

    /**
     * Position in world
     */
    protected Vector worldPos;

    public Camera(String name) {
        this.name = name;
        this.worldPos = new Vector();
    }

    public String getName() {
        return name;
    }
}
