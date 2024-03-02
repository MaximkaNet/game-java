package cz.cvut.fel.zavadmak.core;

import cz.cvut.fel.zavadmak.Camera;
import cz.cvut.fel.zavadmak.Player;
import cz.cvut.fel.zavadmak.World;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameLoopHandler extends AnimationTimer {
    private final InputManager input = InputManager.getInstance();
    private final double speed = 60;
    private World world;
    private RenderProvider renderProvider;

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public RenderProvider getRenderProvider() {
        return renderProvider;
    }

    public void setRenderProvider(RenderProvider renderProvider) {
        this.renderProvider = renderProvider;
    }

    @Override
    public void start() {
        if(renderProvider == null) {
            System.err.println("Render provider is not defined");
            return;
        }
        super.start();
    }

    @Override
    public void handle(long l) {
        Player player = world.getPlayer();
        Camera camera = world.getCamera();

        player.getVelocity().set(0, 0);
        camera.getVelocity().set(0, 0);

        // Handle input
        handleInput(player);

        // Move player
        player.getVelocity().multiply(1 / 60.0);
        player.getWorldPosition().add(player.getVelocity());

        // Calculate camera position
        calcCameraMove(player, camera);

        // Move camera
        camera.getVelocity().multiply(1 / 60.0);
        camera.getWorldPosition().add(camera.getVelocity());

        // Set screen position
        player.getScreenPosition().set(player.getWorldX() - camera.getWorldX(), player.getWorldY() - camera.getWorldY());

        for (GameObject o : world.getGameObjects()) {
            o.getScreenPosition().set(o.getWorldX() - camera.getWorldX(), o.getWorldY() - camera.getWorldY());
        }

        // Clear canvas
        GraphicsContext context = renderProvider.getGraphicsContext2D();
        context.setFill(Color.SILVER);
        context.fillRect(0, 0, context.getCanvas().getWidth(), context.getCanvas().getHeight());

        // Render world
        world.render(renderProvider.getGraphicsContext2D());
    }

    private void handleInput(Player player) {
        if (input.getKey("w") || input.getKey("up")) {
            player.getVelocity().add(0, -speed);
        }
        if (input.getKey("s") || input.getKey("down")) {
            player.getVelocity().add(0, speed);
        }
        if (input.getKey("a") || input.getKey("left")) {
            player.getVelocity().add(-speed, 0);
        }
        if (input.getKey("d") || input.getKey("right")) {
            player.getVelocity().add(speed, 0);
        }
    }

    private void calcCameraMove(Player player, Camera camera) {
        // Get edges position for camera
        double cameraTopWorldPosition = camera.getWorldY();
        double cameraBottomWorldPosition = camera.getWorldY() + camera.getHeight();
        double cameraLeftWorldPosition = camera.getWorldX();
        double cameraRightWorldPosition = camera.getWorldX() + camera.getWidth();

        // Get edges position for player
        double playerTopWorldPosition = player.getWorldY();
        double playerBottomWorldPosition = player.getWorldY() + player.getBoundary().getHeight();
        double playerLeftWorldPosition = player.getWorldX();
        double playerRightWorldPosition = player.getWorldX() + player.getBoundary().getWidth();

        // Add velocity for camera
        if (playerLeftWorldPosition - cameraLeftWorldPosition < camera.getBorderDistance()) {
            camera.getVelocity().add(-speed, 0);
        }
        if (cameraRightWorldPosition - playerRightWorldPosition < camera.getBorderDistance()) {
            camera.getVelocity().add(speed, 0);
        }
        if (playerTopWorldPosition - cameraTopWorldPosition < camera.getBorderDistance()) {
            camera.getVelocity().add(0, -speed);
        }
        if (cameraBottomWorldPosition - playerBottomWorldPosition < camera.getBorderDistance()) {
            camera.getVelocity().add(0, speed);
        }
    }
}
