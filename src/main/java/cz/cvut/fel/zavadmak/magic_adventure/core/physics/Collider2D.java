package cz.cvut.fel.zavadmak.core.physics;

public class Collider2D extends Collider {
    private double width;
    private double height;
    private double deg;

    public Collider2D(double x, double y, double width, double height) {
        this(x, y, width, height, 0);
    }
    public Collider2D(double x, double y, double width, double height, double deg) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.deg = deg;
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

    public boolean overlapsTop(Collider2D other) {
        return other.getY() + other.height < this.getY();
    }

    public boolean overlapsBottom(Collider2D other) {
        return this.getY() + this.height < other.getY();
    }

    public boolean overlapsLeft(Collider2D other) {
        return other.getX() + other.width < this.getX();
    }

    public boolean overlapsRight(Collider2D other) {
        return this.getX() + this.width < other.getX();
    }

    @Override
    public boolean overlaps(Collider other) {
        Collider2D target = (Collider2D) other;
        return overlapsTop(target) || overlapsBottom(target) || overlapsLeft(target) || overlapsRight(target);
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

}
