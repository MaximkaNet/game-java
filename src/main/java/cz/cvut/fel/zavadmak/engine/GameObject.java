package cz.cvut.fel.zavadmak.magic_adventure.core;

import cz.cvut.fel.zavadmak.magic_adventure.core.physics.Collider2D;
import cz.cvut.fel.zavadmak.magic_adventure.core.utils.Vector;
import cz.cvut.fel.zavadmak.magic_adventure.core.material.Material;
import cz.cvut.fel.zavadmak.magic_adventure.core.physics.Collider;

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

    public Collider getCollider() {
        return collider;
    }
}
