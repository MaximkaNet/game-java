package cz.cvut.fel.zavadmak.core;

import cz.cvut.fel.zavadmak.core.utils.Vector;
import javafx.scene.image.Image;

public class GameObject {

    /**
     * Position in world
     */
    protected Vector worldPos;

    /**
     * Position on screen
     */
    protected Vector screenPos;

    /**
     * The object collider
     */
    protected Collider boundary;

    /**
     * The object image
     */
    protected Image image;

    public GameObject() {
        worldPos = new Vector(0, 0);
        screenPos = new Vector(0, 0);
        boundary = new Collider(0, 0, 0, 0);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(String filename) {
        image = new Image(filename);
        boundary.setWidth(image.getWidth());
        boundary.setHeight(image.getHeight());
    }

    public double getWorldX() {
        return worldPos.getX();
    }

    public double getWorldY() {
        return worldPos.getY();
    }

    public Vector getWorldPosition() {
        return worldPos;
    }

    public double getScreenX() {
        return screenPos.getX();
    }

    public double getScreenY() {
        return screenPos.getY();
    }

    public Vector getScreenPosition() {
        return screenPos;
    }

    public void setWorldPosition(double x, double y) {
        worldPos.set(x, y);
    }

    public void setWorldPosition(Vector v) {
        worldPos.set(v.getX(), v.getY());
    }

    public void setScreenPosition(double x, double y) {
        screenPos.set(x, y);
    }

    public void setScreenPosition(Vector v) {
        screenPos.set(v.getX(), v.getY());
    }

    public Collider getBoundary() {
        return boundary;
    }
}
