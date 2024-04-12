package cz.cvut.fel.zavadmak.magic_adventure.helpers;

import cz.cvut.fel.zavadmak.engine.utils.Vector;

public class PlayerMeta {
    private Vector worldPosition;
    private String scenarioPart;

    public void setScenarioPart(String scenarioPart) {
        this.scenarioPart = scenarioPart;
    }

    public void setWorldPosition(Vector worldPosition) {
        this.worldPosition = worldPosition;
    }

    public Vector getWorldPosition() {
        return worldPosition;
    }

    public String getScenarioPart() {
        return scenarioPart;
    }
}
