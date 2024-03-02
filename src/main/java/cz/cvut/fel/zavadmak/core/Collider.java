package cz.cvut.fel.zavadmak.core;

public class Collider {
    private double x;
    private double y;
    private double width;
    private double height;

    public Collider(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public boolean overlapsTop(Collider other) {
        return other.y + other.height < this.y;
    }
    public boolean overlapsBottom(Collider other) {
        return this.y + this.height < other.y;
    }
    public boolean overlapsLeft(Collider other) {
        return other.x + other.width < this.x;
    }
    public boolean overlapsRight(Collider other) {
        return this.x + this.width < other.x;
    }
    public boolean overlaps(Collider other) {
        return overlapsTop(other) || overlapsBottom(other) || overlapsLeft(other) || overlapsRight(other);
    }

    public void setWidth(double width) {
        this.width = width;
    }
    public void setHeight(double height) {
        this.height = height;
    }
}
