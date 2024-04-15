package cz.cvut.fel.zavadmak.engine.utils;

public class Vector {
    private double x;
    private double y;

    /**
     * Variable for check magnitude
     */
    public final double kEpsilon = 0.00001d;

    public Vector() {
        this(0, 0);
    }

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

    public static double magnitude(Vector vector) {
        return Math.sqrt(vector.x * vector.x + vector.y * vector.y);
    }

    public Vector normalized() {
        double mag = Vector.magnitude(this);
        if (mag > kEpsilon) {
            // normalized vector
            return new Vector(x / mag, y / mag);
        } else {
            // zero vector
            return new Vector(0, 0);
        }
    }
}
