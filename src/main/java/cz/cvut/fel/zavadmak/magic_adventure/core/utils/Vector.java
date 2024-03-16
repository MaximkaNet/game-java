package cz.cvut.fel.zavadmak.core.utils;

public class Vector {
    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void add(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public void add(Vector other) {
        this.x += other.x;
        this.y += other.y;
    }

    public void multiply(double m) {
        this.x *= m;
        this.y *= m;
    }
}
