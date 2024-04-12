package cz.cvut.fel.zavadmak.magic_adventure.domain;

import cz.cvut.fel.zavadmak.engine.GameObject;
import cz.cvut.fel.zavadmak.engine.utils.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class World {

    /**
     * The player instance
     */
    private Player player;

    /**
     * All world layers
     */
    private final Map<Layer, ArrayList<GameObject>> layers = new HashMap<>();

    public enum Layer {
        /**
         * Background layer
         */
        BACKGROUND,

        /**
         * Ground effects
         */
        GROUND_EFFECTS,

        /**
         * All environment game objects
         */
        ENVIRONMENT
    }

    public World() {
        layers.put(Layer.BACKGROUND, new ArrayList<>());
        layers.put(Layer.GROUND_EFFECTS, new ArrayList<>());
        layers.put(Layer.ENVIRONMENT, new ArrayList<>());
    }

    /**
     * Get world layers
     *
     * @return Map
     */
    public Map<Layer, ArrayList<GameObject>> getLayers() {
        return layers;
    }

    /**
     * Create and set a new player
     *
     * @param nickname The player nickname
     * @param worldPos The player world position
     */
    public void setPlayer(String nickname, Vector worldPos) {
        player = new Player(nickname);
        player.setWorldPosition(worldPos.getX(), worldPos.getY());
    }

    /**
     * Set player
     *
     * @param player The player instance
     */
    public void setPlayer(Player player) {
        if(player == null) {
            System.err.println("Player if null");
            setPlayer("default", new Vector(0,0));
            return;
        }
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<GameObject> getLayer(Layer layer) {
        return layers.get(layer);
    }
}
