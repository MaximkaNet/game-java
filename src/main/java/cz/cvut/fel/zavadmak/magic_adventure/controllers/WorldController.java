package cz.cvut.fel.zavadmak.magic_adventure.controllers;

import cz.cvut.fel.zavadmak.engine.GameObject;
import cz.cvut.fel.zavadmak.engine.ViewController;
import cz.cvut.fel.zavadmak.engine.input.InputManager;
import cz.cvut.fel.zavadmak.engine.material.Material;
import cz.cvut.fel.zavadmak.engine.utils.JSONLoader;
import cz.cvut.fel.zavadmak.magic_adventure.FollowCamera;
import cz.cvut.fel.zavadmak.magic_adventure.domain.Player;
import cz.cvut.fel.zavadmak.magic_adventure.helpers.PlayerMeta;
import cz.cvut.fel.zavadmak.magic_adventure.helpers.SaveHelper;
import cz.cvut.fel.zavadmak.engine.utils.Vector;
import cz.cvut.fel.zavadmak.magic_adventure.domain.World;
import cz.cvut.fel.zavadmak.magic_adventure.domain.block.Grass;
import cz.cvut.fel.zavadmak.engine.scenario.ScenarioHelper;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class WorldController extends AnimationTimer implements ViewController {
    /**
     * Input manager instance
     */
    private final InputManager inputManager = InputManager.getInstance();

    /**
     * Delta time between new time and last time
     */
    private long deltaTime = 0;

    /**
     * Last update time
     */
    protected long lastTime = 0;

    /**
     * World wrapper (model).
     */
    private final World theWorld = new World();

    private final FollowCamera followCamera = new FollowCamera(theWorld.getPlayer());

    /**
     * Main graphics context
     */
    private GraphicsContext graphicsContext;

    public WorldController() {
    }

    public World getWorld() {
        return theWorld;
    }

    @Override
    public void startHandling() {
        if (graphicsContext != null) {
//            followCamera.setGraphicsContext(graphicsContext);
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
     * Load world from scenarios folder. It is a model of the world.
     *
     * @param scenarioName The save folder name
     */
    public void loadWorld(String scenarioName, String part) {
        String scenariosDir = "scenarios";
        ScenarioHelper scenarioHelper = new ScenarioHelper(scenariosDir, scenarioName);
        if (!scenarioHelper.loadPart(part)) {
            System.err.println("Scenario part " + part + " is not loaded");
            return;
        }
        // 1. Load layers
        scenarioHelper.getLayers().forEach((Object object) -> {
            // Convert object to JSON object
            JSONObject jsonLayer = (JSONObject) object;
            // Get the world layer
            ArrayList<GameObject> worldLayer = theWorld.getLayer(World.Layer.valueOf(jsonLayer.getString("name").toUpperCase()));
            // Get asset
            JSONObject asset = jsonLayer.getJSONObject("asset");
            // Get path to asset
            String assetPath = asset.getString("path");
            // Get asset resolution
            double width = 32, height = 32;
            if (asset.has("resolution")) {
                JSONObject assetResolution = asset.getJSONObject("resolution");
                width = assetResolution.getDouble("width");
                height = assetResolution.getDouble("height");
            }
            // Load asset
            Material material = new Material(assetPath, width, height, true, true);
            // Add new instances of asset to world layer
            JSONArray positions = jsonLayer.getJSONArray("positions");
            positions.forEach((positionObject) -> {
                // Get asset world position
                JSONObject assetWorldPosition = (JSONObject) positionObject;
                double assetWorldX = assetWorldPosition.getDouble("x");
                double assetWorldY = assetWorldPosition.getDouble("y");
                Grass grassBlock = new Grass(assetWorldX, assetWorldY);
                grassBlock.applyMaterial(material);
                // Add block to the world layer
                worldLayer.add(grassBlock);
            });
        });
        // 2. Process spawn points
        // ...
        // 3. Load save ... (maybe from entry application point)
    }

    /**
     * Load save
     *
     * @param saveName The save name
     */
    public String loadSave(String saveName) throws Exception {
        String savesDir = "saves";
        SaveHelper saveHelper = new SaveHelper(savesDir, saveName);
        if (!saveHelper.load()) {
            throw new Exception("Save is not loaded");
        }
        // Get player data
        PlayerMeta playerMeta = saveHelper.getPlayer();
        // Set player data
        Player worldPlayer = theWorld.getPlayer();
        worldPlayer.setWorldPosition(playerMeta.getWorldPosition());
        return playerMeta.getScenarioPart();
    }

    /**
     * Temporary method
     */
    public void loadPlayer() {
        try {
            JSONObject jsonPlayer = JSONLoader.load("config/player.json");
            theWorld.setPlayer(jsonPlayer.getString("nickname"), new Vector(0, 0));
            Material playerMaterial = new Material("assets/actor/Hero.png", 32, 32, true, true);
            theWorld.getPlayer().applyMaterial(playerMaterial);
            theWorld.getPlayer().setSpeed(2);
//            followCamera.follow(theWorld.getPlayer());
        } catch (Exception e) {
            // logger ...
        }
    }

    /**
     * Update method for game object
     *
     * @param deltaTime time from last update
     */
    public void update(long deltaTime) {
        theWorld.getPlayer().getVelocity().set(0, 0);
        if (inputManager.isKeyDown("W")) {
            theWorld.getPlayer().addMovementY(-1);
        }
        if (inputManager.isKeyDown("S")) {
            theWorld.getPlayer().addMovementY(1);
        }
        if (inputManager.isKeyDown("D")) {
            theWorld.getPlayer().addMovementX(1);
        }
        if (inputManager.isKeyDown("A")) {
            theWorld.getPlayer().addMovementX(-1);
        }
        // Move player
        theWorld.getPlayer().move();
        // Move camera
//        followCamera.move(deltaTime);
    }

    /**
     * Draw method for game object
     *
     * @param gc GraphicsContext
     */
    public void draw(GraphicsContext gc) {
        clearGC(gc);

        theWorld.getLayer(World.Layer.BACKGROUND).forEach((GameObject obj) -> {
//            followCamera.render(obj);
            gc.drawImage(obj.getMaterial(),
                    obj.getWorldX() * obj.getMaterial().getWidth(),
                    obj.getWorldY() * obj.getMaterial().getHeight());
        });
        gc.drawImage(theWorld.getPlayer().getMaterial(), theWorld.getPlayer().getWorldX(), theWorld.getPlayer().getWorldY());
//        followCamera.renderPlayer(theWorld.getPlayer());
    }

    /**
     * Clear graphics context
     *
     * @param gc GraphicsContext
     */
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
