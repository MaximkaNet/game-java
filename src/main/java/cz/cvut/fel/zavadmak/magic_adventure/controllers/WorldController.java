package cz.cvut.fel.zavadmak.magic_adventure.controllers;

import cz.cvut.fel.zavadmak.engine.GameObject;
import cz.cvut.fel.zavadmak.engine.ViewController;
import cz.cvut.fel.zavadmak.engine.input.InputManager;
import cz.cvut.fel.zavadmak.engine.material.Material;
import cz.cvut.fel.zavadmak.engine.utils.Vector;
import cz.cvut.fel.zavadmak.magic_adventure.domain.World;
import cz.cvut.fel.zavadmak.magic_adventure.domain.block.Grass;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class WorldController extends AnimationTimer implements ViewController {
    private final InputManager inputManager = InputManager.getInstance();
    private long deltaTime = 0;
    protected long lastTime = 0;
    private final World theWorld = new World();
    private GraphicsContext graphicsContext;

    public WorldController() {
    }

    public World getWorld() {
        return theWorld;
    }

    @Override
    public void startHandling() {
        if (graphicsContext != null) {
            super.start();
        } else {
            System.err.println("Please set graphics context before starting");
        }
    }

    @Override
    public void shutdownController() {
        super.stop();
    }

    public void setGraphicsContext(GraphicsContext gc) {
        this.graphicsContext = gc;
    }

    /**
     * Load world from saves folder
     *
     * @param saveName The save folder name
     */
    public void loadWorld(String saveName) {
        theWorld.setPlayer("nickname", new Vector(0, 0));
        Material playerMaterial = new Material("/assets/actor/Hero.png", 32, 32, true, true);
        theWorld.getPlayer().applyMaterial(playerMaterial);
        // Get layer from world
        List<GameObject> bgLayer = theWorld.getLayer(World.Layer.BACKGROUND);
        // Get material
        Material grassMaterial = new Material("/assets/environment/floor/grass.png", 32, 32, true, true);
        // Add game objects to layer
        for (int i = 0; i < 32 * 15; i += 32) {
            for (int j = 0; j < 32 * 15; j += 32) {
                Grass object = new Grass(i, j);
                object.applyMaterial(grassMaterial);
                bgLayer.add(object);
            }
        }
    }

    /**
     * Update method for game object
     *
     * @param deltaTime time from last update
     */
    public void update(long deltaTime) {
        theWorld.getPlayer().getVelocity().set(0, 0);
        double speed = 3;
        if (inputManager.isKeyDown("W")) {
            theWorld.getPlayer().getVelocity().add(0, -speed);
        }
        if (inputManager.isKeyDown("S")) {
            theWorld.getPlayer().getVelocity().add(0, speed);
        }
        if (inputManager.isKeyDown("D")) {
            theWorld.getPlayer().getVelocity().add(speed, 0);
        }
        if (inputManager.isKeyDown("A")) {
            theWorld.getPlayer().getVelocity().add(-speed, 0);
        }
        theWorld.getPlayer().move();
    }

    /**
     * Draw method for game object
     *
     * @param gc GraphicsContext
     */
    public void draw(GraphicsContext gc) {
        clearGC(gc);
        theWorld.getLayer(World.Layer.BACKGROUND).forEach((GameObject obj) -> {
            gc.drawImage(obj.getMaterial(), obj.getWorldX(), obj.getWorldY());
        });
        gc.drawImage(theWorld.getPlayer().getMaterial(), theWorld.getPlayer().getWorldX(), theWorld.getPlayer().getWorldY());
    }

    private void clearGC(GraphicsContext gc) {
        gc.setFill(Color.SILVER);
        gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    @Override
    public void handle(long l) {
        deltaTime = l - lastTime;
        lastTime = l;
        update(deltaTime);
        draw(graphicsContext);
    }
}
