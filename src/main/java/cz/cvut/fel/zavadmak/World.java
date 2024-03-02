package cz.cvut.fel.zavadmak;

import cz.cvut.fel.zavadmak.core.Collider;
import cz.cvut.fel.zavadmak.core.GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class World {

    /**
     * Player
     */
    private Player player;

    /**
     * Array represent game object in the world
     */
    private ArrayList<GameObject> gameObjects = new ArrayList<>();

    private Camera camera;
    // Level
    // Inventory

    public void setPlayer(Player player) {
        this.player = player;
    }
    public Player getPlayer() {
        return player;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Camera getCamera() {
        return this.camera;
    }

    public void addGameObject(GameObject o) {
        gameObjects.add(o);
    }

    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void render(GraphicsContext context) {
        // Render sprite
//        player.render();
        context.drawImage(player.getImage(), player.getScreenX(), player.getScreenY());
        // Render collider of player
        context.setFill(Color.GREEN);
        Collider boundary = player.getBoundary();
        context.strokeRect(player.getScreenX(), player.getScreenY(),
                boundary.getX() + boundary.getWidth(), boundary.getY() + boundary.getHeight());

        for (GameObject o: gameObjects) {
            context.drawImage(o.getImage(), o.getScreenX(), o.getScreenY());
        }
    }
}
