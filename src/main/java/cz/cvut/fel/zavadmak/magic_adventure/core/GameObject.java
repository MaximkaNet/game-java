package cz.cvut.fel.zavadmak.core;

import cz.cvut.fel.zavadmak.core.physics.Collider2D;
import cz.cvut.fel.zavadmak.core.utils.Vector;
import cz.cvut.fel.zavadmak.core.material.Material;
import cz.cvut.fel.zavadmak.core.physics.Collider;
import org.jetbrains.annotations.NotNull;

public abstract class GameObject {

    /**
     * Position in world
     */
    protected Vector worldPos;

    /**
     * The object collider
     */
    protected Collider collider;

    /**
     * The object material
     */
    protected Material material;

    public GameObject() {
        worldPos = new Vector(0, 0);
        collider = new Collider2D(0, 0, 0, 0);
    }

    public Material getMaterial() {
        return material;
    }

    @NotNull
    public void applyMaterial(Material m) {
        this.material = m;
    }

    public void clearMaterial() {
        material = null;
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

    public void setWorldPosition(double x, double y) {
        worldPos.set(x, y);
    }

    public Collider getCollider() {
        return collider;
    }
}
