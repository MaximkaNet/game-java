package cz.cvut.fel.zavadmak.engine.utils;

import cz.cvut.fel.zavadmak.engine.GameObject;

public class SpawnPoint {
    /**
     * Reference to game object
     */
    private final GameObject gameObjectRef;
    private final Vector point;

    public SpawnPoint(Vector point, GameObject gameObject) {
        this.point = point;
        this.gameObjectRef = gameObject;
    }

    public GameObject getGameObjectRef() {
        return gameObjectRef;
    }

    public double getX() {
        return point.getX();
    }

    public double getY() {
        return point.getY();
    }
}
