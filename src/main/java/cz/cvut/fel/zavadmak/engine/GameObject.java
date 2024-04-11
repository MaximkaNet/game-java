package cz.cvut.fel.zavadmak.engine;

import cz.cvut.fel.zavadmak.engine.material.Material;
import cz.cvut.fel.zavadmak.engine.physics.Collider;
import cz.cvut.fel.zavadmak.engine.utils.Vector;

public abstract class GameObject {
    /**
     * The game object name
     */
    protected String name;

    /**
     * Position in world
     */
    protected Vector worldPos;

    /**
     * The object material
     */
    protected Material material;

    /**
     * The object collider
     */
    protected Collider collider;

    public GameObject() {
        worldPos = new Vector(0, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getMaterial() {
        return material;
    }

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
}
