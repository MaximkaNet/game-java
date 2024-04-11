package cz.cvut.fel.zavadmak.engine.physics;

import cz.cvut.fel.zavadmak.engine.utils.Vector;

public class RectangleCollider implements Collider {
    /**
     * The world collider position
     */
    protected Vector position;

    /**
     * Collider width
     */
    private double width;

    /**
     * Collider height
     */
    private double height;

    /**
     * Rotation degree
     */
    private double deg;

    /**
     * Rotation origin
     */
    private Vector origin;

    public RectangleCollider(double x, double y, double width, double height) {
        this(x, y, width, height, 0);
    }
    public RectangleCollider(double x, double y, double width, double height, double deg) {
        this.width = width;
        this.height = height;
        this.deg = deg;
    }

    public double getX() {
        return position.getX();
    }
    public double getY() {
        return position.getY();
    }
    public Vector getPosition() {
        return position;
    }

    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public double getDeg() {
        return deg;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setDegree(double deg) {
        this.deg = deg;
    }
    public boolean overlaps(Collider other) {
        RectangleCollider target = (RectangleCollider) other;
        return false;
//        return overlapsTop(target) || overlapsBottom(target) || overlapsLeft(target) || overlapsRight(target);
    }
}
