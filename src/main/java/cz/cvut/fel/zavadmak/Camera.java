package cz.cvut.fel.zavadmak;

import cz.cvut.fel.zavadmak.core.GameObject;
import cz.cvut.fel.zavadmak.core.factory.IMovable;
import cz.cvut.fel.zavadmak.core.utils.Vector;

public class Camera extends GameObject implements IMovable {
    private Vector velocity;
    private double width;
    private double height;
    private double borderDistance;

    public Camera() {
        velocity = new Vector(0, 0);
        width = 0;
        height = 0;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getBorderDistance() {
        return borderDistance;
    }

    public void setWidth(double w) {
        this.width = w;
    }

    public void setHeight(double h) {
        this.height = h;
    }

    public void setBorderDistance(double distance) {
        this.borderDistance = distance;
    }
}
