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

    public static Vector smoothDamp(Vector current, Vector target, Vector currentVelocity, double smoothTime, double maxSpeed, long deltaTime) {
        double output_x = 0f;
        double output_y = 0f;

        // Based on Game Programming Gems 4 Chapter 1.10

        smoothTime = Math.max(0.0001D, smoothTime);
        double omega = 2F / smoothTime;

        double x = omega * deltaTime;
        double exp = 1F / (1F + x + 0.48F * x * x + 0.235F * x * x * x);

        double change_x = current.x - target.x;
        double change_y = current.y - target.y;
        Vector originalTo = target;

        // Clamp maximum speed
        double maxChange = maxSpeed * smoothTime;

        double maxChangeSq = maxChange * maxChange;
        double sqrmag = change_x * change_x + change_y * change_y;
        if (sqrmag > maxChangeSq)
        {
            double mag = Math.sqrt(sqrmag);
            change_x = change_x / mag * maxChange;
            change_y = change_y / mag * maxChange;
        }

        target.x = current.x - change_x;
        target.y = current.y - change_y;

        double temp_x = (currentVelocity.x + omega * change_x) * deltaTime;
        double temp_y = (currentVelocity.y + omega * change_y) * deltaTime;

        currentVelocity.x = (currentVelocity.x - omega * temp_x) * exp;
        currentVelocity.y = (currentVelocity.y - omega * temp_y) * exp;

        output_x = target.x + (change_x + temp_x) * exp;
        output_y = target.y + (change_y + temp_y) * exp;

        // Prevent overshooting
        double origMinusCurrent_x = originalTo.x - current.x;
        double origMinusCurrent_y = originalTo.y - current.y;
        double outMinusOrig_x = output_x - originalTo.x;
        double outMinusOrig_y = output_y - originalTo.y;

        if (origMinusCurrent_x * outMinusOrig_x + origMinusCurrent_y * outMinusOrig_y > 0)
        {
            output_x = originalTo.x;
            output_y = originalTo.y;

            currentVelocity.x = (output_x - originalTo.x) / deltaTime;
            currentVelocity.y = (output_y - originalTo.y) / deltaTime;
        }

        return new Vector(output_x, output_y);
    }
}
