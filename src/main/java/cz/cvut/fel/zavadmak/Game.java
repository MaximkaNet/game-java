package cz.cvut.fel.zavadmak;

import cz.cvut.fel.zavadmak.core.GameLoopHandler;
import cz.cvut.fel.zavadmak.core.GameObject;
import cz.cvut.fel.zavadmak.core.InputManager;
import cz.cvut.fel.zavadmak.core.RenderProvider;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Game extends Application {
    private final Group ROOT_ELEMENT = new Group();
    private final RenderProvider renderProvider = new RenderProvider();
    private World world = new World();
    private Scene primaryScene;
    private double sceneWidth;
    private double sceneHeight;

    @Override
    public void init() {
        Rectangle2D primaryScreen = Screen.getPrimary().getBounds();

        sceneWidth = primaryScreen.getWidth() / 2;
        sceneHeight = primaryScreen.getHeight() / 2;

        // Make primary scene
        // Create a scene at half the screen size
        primaryScene = new Scene(ROOT_ELEMENT, sceneWidth, sceneHeight);

        renderProvider.setWidth(sceneWidth);
        renderProvider.setHeight(sceneHeight);

        ROOT_ELEMENT.getChildren().add(renderProvider);
    }

    @Override
    public void start(Stage stage) {
        // Init world
        initWorld();

        // Get input manager
        InputManager input = InputManager.getInstance();

        // Add event filters
        stage.addEventFilter(KeyEvent.KEY_PRESSED, input.getEventKeyPressed());
        stage.addEventFilter(KeyEvent.KEY_RELEASED, input.getEventKeyReleased());

        // Initialize game loop
        GameLoopHandler gameLoop = new GameLoopHandler();
        // Set world to handle
        gameLoop.setWorld(world);
        // Set render provider
        gameLoop.setRenderProvider(renderProvider);

        // Set border size for camera
        world.getCamera().setBorderDistance(10);

        // Start game loop
        gameLoop.start();

        // Stage config
        stage.setTitle("2D game engine");
        stage.setScene(primaryScene);

        primaryScene.heightProperty().addListener((observable -> {
            // Resize canvas
            renderProvider.setWidth(primaryScene.getWidth());
            // Resize camera
            if (world.getCamera() != null) {
                world.getCamera().setWidth(primaryScene.getWidth());
            }
        }));

        primaryScene.heightProperty().addListener((observable -> {
            // Resize canvas
            renderProvider.setHeight(primaryScene.getHeight());
            // Resize camera
            if (world.getCamera() != null) {
                world.getCamera().setHeight(primaryScene.getHeight());
            }
        }));

        // Show window
        stage.show();
    }

    public void initWorld() {
        Camera camera = new Camera();
        camera.setScreenPosition(0, 0);
        camera.setWorldPosition(0, 0);
        camera.setWidth(sceneWidth);
        camera.setHeight(sceneHeight);

        Player player = new Player();
        player.setImage("images/smile.png");

        GameObject wall = new GameObject();
        wall.setImage("images/wall.png");
        wall.setWorldPosition(10, 45);

        GameObject wall2 = new GameObject();
        wall2.setImage("images/wall.png");
        wall2.setWorldPosition(20, 15);

        GameObject wall3 = new GameObject();
        wall3.setImage("images/wall.png");
        wall3.setWorldPosition(30, 55);

        GameObject wall4 = new GameObject();
        wall4.setImage("images/wall.png");
        wall4.setWorldPosition(36, 22);

        GameObject wall5 = new GameObject();
        wall5.setImage("images/wall.png");
        wall5.setWorldPosition(42, 15);

        GameObject wall6 = new GameObject();
        wall6.setImage("images/wall.png");
        wall6.setWorldPosition(55, 55);

        // Camera and player
        world.setCamera(camera);
        world.setPlayer(player);

        // Game objects
        world.addGameObject(wall);
        world.addGameObject(wall2);
        world.addGameObject(wall2);
        world.addGameObject(wall3);
        world.addGameObject(wall4);
        world.addGameObject(wall5);
        world.addGameObject(wall6);
    }

    public static void main(String[] args) {
        launch(args);
    }
}