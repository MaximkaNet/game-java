package cz.cvut.fel.zavadmak.magic_adventure.domain;

import cz.cvut.fel.zavadmak.engine.GameObject;
import cz.cvut.fel.zavadmak.engine.utils.SpawnPoint;
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
    private final HashMap<Layer, ArrayList<GameObject>> layers = new HashMap<>();

    /**
     * The world entities
     */
    private final HashMap<String, GameObject> entities = new HashMap<>();

    /**
     * The world spawn points
     */
    private final ArrayList<SpawnPoint> spawnPoints = new ArrayList<>();

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
        if (player == null) {
            System.err.println("Player if null");
            setPlayer("default", new Vector(0, 0));
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

    /**
     * Add entity to world
     *
     * @param name   The entity name
     * @param entity The entity
     */
    public void addEntity(String name, GameObject entity) {
        entities.put(name, entity);
    }

    /**
     * Remove entity from world
     *
     * @param name The entity name
     */
    public void removeEntity(String name) {
        entities.remove(name);
    }

    /**
     * Get entities as pair (entityName, entity)
     *
     * @return HashMap
     */
    public HashMap<String, GameObject> getEntities() {
        return entities;
    }

    /**
     * Check game object in spawn points using GameObject name
     *
     * @param gameObject The game object
     * @return TRUE if game object contains, FALSE otherwise
     */
    public boolean gameObjectContainsInSpawnPoints(GameObject gameObject) {
        for (SpawnPoint spawnPoint : spawnPoints) {
            if (spawnPoint.getGameObjectRef().getName() == gameObject.getName()) {
                return true;
            }
        }
        return false;
    }

    public void addSpawnPoint(Vector point, GameObject gameObject) {
        if (gameObjectContainsInSpawnPoints(gameObject)) {
            return;
        }
        spawnPoints.add(new SpawnPoint(point, gameObject));
    }

    public ArrayList<SpawnPoint> getSpawnPoints() {
        return spawnPoints;
    }
}
