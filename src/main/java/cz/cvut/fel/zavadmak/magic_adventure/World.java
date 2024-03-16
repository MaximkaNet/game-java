package cz.cvut.fel.zavadmak;

public class World {

//    /**
//     * Player
//     */
//    private Player player;
//
//    /**
//     * Array represent game object in the world
//     */
//    private ArrayList<GameObject> gameObjects = new ArrayList<>();
//
//    private Camera camera;
//
//    private double speed = 120;
//    private final InputManager input = InputManager.getInstance();
//    // Level
//    // Inventory
//
//    public void setPlayer(Player player) {
//        this.player = player;
//    }
//    public Player getPlayer() {
//        return player;
//    }
//
//    public void setCamera(Camera camera) {
//        this.camera = camera;
//    }
//
//    public Camera getCamera() {
//        return this.camera;
//    }
//
//    public void addGameObject(GameObject o) {
//        gameObjects.add(o);
//    }
//
//    public ArrayList<GameObject> getGameObjects() {
//        return gameObjects;
//    }
//
//    public void update() {
//        player.getVelocity().set(0, 0);
//        camera.getVelocity().set(0, 0);
//
//        // Handle input
//        handleInput(player);
//
//        // Move player
//        player.getVelocity().multiply(1 / 60.0);
//        player.getWorldPosition().add(player.getVelocity());
//
//        // Calculate camera position
//        calcCameraMove(player, camera);
//
//        // Move camera
//        camera.getVelocity().multiply(1 / 60.0);
//        camera.getWorldPosition().add(camera.getVelocity());
//
//        // Set player screen position
//        player.getScreenPosition().set(player.getWorldX() - camera.getWorldX(), player.getWorldY() - camera.getWorldY());
//
//        for (GameObject o : this.getGameObjects()) {
//            o.getScreenPosition().set(o.getWorldX() - camera.getWorldX(), o.getWorldY() - camera.getWorldY());
//        }
//    }
//
//    private void handleInput(Player player) {
//        double acceleration = 50;
//        if (input.getKey("w") || input.getKey("up")) {
//            if (input.getKey("shift")) {
//                player.getVelocity().add(0, -speed - acceleration);
//            } else {
//                player.getVelocity().add(0, -speed);
//            }
//        }
//        if (input.getKey("s") || input.getKey("down")) {
//            if (input.getKey("shift")) {
//                player.getVelocity().add(0, speed + acceleration);
//            } else
//                player.getVelocity().add(0, speed);
//        }
//        if (input.getKey("a") || input.getKey("left")) {
//            if (input.getKey("shift")) {
//                player.getVelocity().add(-speed - acceleration, 0);
//            } else
//                player.getVelocity().add(-speed, 0);
//        }
//        if (input.getKey("d") || input.getKey("right")) {
//            if (input.getKey("shift")) {
//                player.getVelocity().add(speed + acceleration, 0);
//            } else
//                player.getVelocity().add(speed, 0);
//        }
//    }
//
//    private void calcCameraMove(Player player, Camera camera) {
//        // Get edges position for camera
//        double cameraTopWorldPosition = camera.getWorldY();
//        double cameraBottomWorldPosition = camera.getWorldY() + camera.getHeight();
//        double cameraLeftWorldPosition = camera.getWorldX();
//        double cameraRightWorldPosition = camera.getWorldX() + camera.getWidth();
//
//        // Get edges position for player
//        double playerTopWorldPosition = player.getWorldY();
//        double playerBottomWorldPosition = player.getWorldY() + player.getCollider().getHeight();
//        double playerLeftWorldPosition = player.getWorldX();
//        double playerRightWorldPosition = player.getWorldX() + player.getCollider().getWidth();
//
//        // Add velocity for camera
//        if (playerLeftWorldPosition - cameraLeftWorldPosition < camera.getBorderDistance()) {
//            camera.getVelocity().add(-speed, 0);
//        }
//        if (cameraRightWorldPosition - playerRightWorldPosition < camera.getBorderDistance()) {
//            camera.getVelocity().add(speed, 0);
//        }
//        if (playerTopWorldPosition - cameraTopWorldPosition < camera.getBorderDistance()) {
//            camera.getVelocity().add(0, -speed);
//        }
//        if (cameraBottomWorldPosition - playerBottomWorldPosition < camera.getBorderDistance()) {
//            camera.getVelocity().add(0, speed);
//        }
//    }
//
//    public void draw(GraphicsContext context) {
//        // Clear canvas
//        context.setFill(Color.SILVER);
//        context.fillRect(0, 0, context.getCanvas().getWidth(), context.getCanvas().getHeight());
//
//        // Render sprite
////        player.render();
//        context.drawImage(player.getMaterial(), player.getScreenX(), player.getScreenY());
//        // Render collider of player
//        context.setFill(Color.GREEN);
//        Collider boundary = player.getCollider();
//        context.strokeRect(player.getScreenX(), player.getScreenY(),
//                boundary.getX() + boundary.getWidth(), boundary.getY() + boundary.getHeight());
//
//        for (GameObject o: gameObjects) {
//            context.drawImage(o.getMaterial(), o.getScreenX(), o.getScreenY());
//        }
//    }
}
