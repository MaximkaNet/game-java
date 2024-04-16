package cz.cvut.fel.zavadmak.magic_adventure;

import cz.cvut.fel.zavadmak.engine.Camera;
import cz.cvut.fel.zavadmak.engine.GameObject;
import cz.cvut.fel.zavadmak.engine.utils.Vector;
import javafx.scene.canvas.GraphicsContext;

public class FollowCamera extends Camera {
    private GameObject target;
    private GraphicsContext gc;
    private double speed = .08;

    Vector offset = new Vector(1, 1);
    double smoothTime = 0.25;
    Vector velocity = new Vector();

    public FollowCamera(GameObject follow) {
        super("follow_camera");
        target = follow;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.gc = graphicsContext;
    }

    /**
     * Render method
     *
     * @param gameObject Object to be rendered
     */
    public void render(GameObject gameObject) {
        if (gameObject.getMaterial() == null)
            return;
        double renderX = gameObject.getWorldX() - this.worldPos.getX();
        double renderY = gameObject.getWorldY() - this.worldPos.getY();
        gc.drawImage(gameObject.getMaterial(), renderX * gameObject.getMaterial().getWidth(), renderY * gameObject.getMaterial().getHeight());
    }

    public void renderPlayer(GameObject gameObject) {
        double renderX = gameObject.getWorldX() - this.worldPos.getX();
        double renderY = gameObject.getWorldY() - this.worldPos.getY();
        gc.drawImage(gameObject.getMaterial(), renderX, renderY);
    }

    public void follow(GameObject gameObject) {
        this.target = gameObject;
    }

    /**
     * The move method
     */
    public void move(long deltaTime) {
        Vector targetPosition = new Vector(target.getWorldX() - 5, target.getWorldY() - 5);
        targetPosition.add(offset);
        Vector smoothPos = Vector.smoothDamp(this.worldPos, targetPosition, velocity, smoothTime, speed, deltaTime);
        this.worldPos.set(smoothPos.getX(), smoothPos.getY());
    }
}
