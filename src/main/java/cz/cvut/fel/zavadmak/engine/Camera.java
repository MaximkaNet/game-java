package cz.cvut.fel.zavadmak.engine;

import cz.cvut.fel.zavadmak.engine.utils.Vector;
import javafx.scene.canvas.GraphicsContext;

public abstract class Camera {
    /**
     * The game object name
     */
    protected String name;

    /**
     * Position in world
     */
    protected Vector worldPos;

    /**
     * Update method for game object
     * @param deltaTime time from last update
     */
    public abstract void update(long deltaTime);

    /**
     * Draw method for game object
     * @param gc GraphicsContext
     */
    public abstract void draw(GraphicsContext gc);
}
