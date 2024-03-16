package cz.cvut.fel.zavadmak;


public class Game {
//    private GameWindow gameWindow;
//    private final RenderProvider renderProvider = new RenderProvider();
//    private final InputManager input = InputManager.getInstance();
//    private World world = new World();
//
//    public Game(GameWindow gameWindow) {
//        this.gameWindow = gameWindow;
//        Group root = (Group) gameWindow.getPrimaryScene().getRoot();
//        // Prepare scene to render
//        renderProvider.setWidth(gameWindow.getPrimaryScene().getWidth());
//        renderProvider.setHeight(gameWindow.getPrimaryScene().getHeight());
//
//        root.getChildren().add(renderProvider);
//    }
//
//    private void getSettingsUI() {
//        Group root = (Group) gameWindow.getPrimaryScene().getRoot();
//
//        CheckBox testSetting = new CheckBox("Test setting");
//        CheckBox testSetting2 = new CheckBox("Test 2 setting");
//
//        testSetting.setSelected(true);
//
//        VBox horizontalBox = new VBox(50);
//
//        horizontalBox.getChildren().add(testSetting);
//        horizontalBox.getChildren().add(testSetting2);
//
//        root.getChildren().add(horizontalBox);
//    }
//
//    public void init() {
//
//    }
//
//    public void start() {
//
//        Stage stage = gameWindow.getWindow();
//        if(stage == null) {
//            return;
//        }
//
////        getSettingsUI();
//
//        // Init world
//        initWorld();
//
//        // Add event filters
//        stage.addEventFilter(KeyEvent.KEY_PRESSED, input.getEventKeyPressed());
//        stage.addEventFilter(KeyEvent.KEY_RELEASED, input.getEventKeyReleased());
//        stage.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
//            if(event.getCode() == KeyCode.F12) {
//                stage.setFullScreen(!stage.isFullScreen());
//            }
//        });
//
//        // Initialize game loop
//        GameLoopHandler gameLoop = new GameLoopHandler();
//        // Set world to handle
//        gameLoop.setWorld(world);
//        // Set render provider
//        gameLoop.setRenderProvider(renderProvider);
//
//        // Set border size for camera
//        world.getCamera().setBorderDistance(40);
//
//        // Start game loop
//        gameLoop.start();
//
//        // GUI
//
//        createGUI();
//
//        gameWindow.getPrimaryScene().heightProperty().addListener((observable -> {
//            // Resize canvas
//            renderProvider.setWidth(gameWindow.getPrimaryScene().getWidth());
//            // Resize camera
//            if (world.getCamera() != null) {
//                world.getCamera().setWidth(gameWindow.getPrimaryScene().getWidth());
//            }
//        }));
//
//        gameWindow.getPrimaryScene().heightProperty().addListener((observable -> {
//            // Resize canvas
//            renderProvider.setHeight(gameWindow.getPrimaryScene().getHeight());
//            // Resize camera
//            if (world.getCamera() != null) {
//                world.getCamera().setHeight(gameWindow.getPrimaryScene().getHeight());
//            }
//        }));
//    }
//
//    public void createGUI() {
//        Image axe = new Image("assets/items/axe.png");
//        Image sesame = new Image("assets/items/sesame.png");
//        Image sword = new Image("assets/items/sword.png");
//
//        // Add items to the items panel
//        HBox itemsPanel = new HBox();
//        itemsPanel.getChildren().add(new ImageView(axe));
//        itemsPanel.getChildren().add(new ImageView(sesame));
//        itemsPanel.getChildren().add(new ImageView(sword));
//
//        // Add styles
////                String inlineStylesForItemsPanel = "-fx-position: ";
////                inlineStylesForItemsPanel += "";
////                itemsPanel.setStyle(inlineStylesForItemsPanel);
//
//        itemsPanel.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 10px; -fx-spacing: 30px");
//
//        AnchorPane pane = new AnchorPane();
//
//        AnchorPane.setBottomAnchor(itemsPanel, 0.0);
//        AnchorPane.setLeftAnchor(itemsPanel, 0.0);
//
//        pane.getChildren().add(itemsPanel);
//
//        Group root = (Group) gameWindow.getPrimaryScene().getRoot();
//        root.getChildren().add(itemsPanel);
//    }
//
//    public void initWorld() {
//        Camera camera = new Camera(world);
//        camera.setScreenPosition(0, 0);
//        camera.setWorldPosition(0, 0);
//        camera.setWidth(gameWindow.getPrimaryScene().getWidth());
//        camera.setHeight(gameWindow.getPrimaryScene().getHeight());
//
//        Player player = new Player(world);
//        player.setImage("images/smile.png");
//
//        GameObject wall = new GameObject();
//        wall.setImage("images/wall.png");
//        wall.setWorldPosition(10, 45);
//
//        GameObject wall2 = new GameObject();
//        wall2.setImage("images/wall.png");
//        wall2.setWorldPosition(20, 15);
//
//        GameObject wall3 = new GameObject();
//        wall3.setImage("images/wall.png");
//        wall3.setWorldPosition(30, 55);
//
//        GameObject wall4 = new GameObject();
//        wall4.setImage("images/wall.png");
//        wall4.setWorldPosition(36, 22);
//
//        GameObject wall5 = new GameObject();
//        wall5.setImage("images/wall.png");
//        wall5.setWorldPosition(42, 15);
//
//        GameObject wall6 = new GameObject();
//        wall6.setImage("images/wall.png");
//        wall6.setWorldPosition(55, 55);
//
//        // Camera and player
//        world.setCamera(camera);
//        world.setPlayer(player);
//
//        // Game objects
//        world.addGameObject(wall);
//        world.addGameObject(wall2);
//        world.addGameObject(wall2);
//        world.addGameObject(wall3);
//        world.addGameObject(wall4);
//        world.addGameObject(wall5);
//        world.addGameObject(wall6);
//    }
}