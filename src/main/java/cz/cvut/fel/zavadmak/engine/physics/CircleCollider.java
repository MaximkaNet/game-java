package cz.cvut.fel.zavadmak.engine.physics;

import cz.cvut.fel.zavadmak.engine.utils.Vector;

public class CircleCollider implements Collider {
    private double radius;

    public CircleCollider(double x, double y) {
        this(x, y, 0);
    }

    @Override
    public boolean overlaps(Collider other) {
        CircleCollider collider = (CircleCollider) other;
        return false;
    }

    @Override
    public Vector getPosition() {
        return null;
    }

    public CircleCollider(double x, double y, double r) {
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }
}
