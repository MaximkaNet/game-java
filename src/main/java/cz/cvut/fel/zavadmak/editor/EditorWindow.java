package cz.cvut.fel.zavadmak.editor;

import cz.cvut.fel.zavadmak.editor.exception.GeneratorException;
import cz.cvut.fel.zavadmak.editor.scenario.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.BLACK;

public class EditorWindow extends Application {
    private Stage mainWindow;
    private Group ROOT_ELEMENT = new Group();
    private Scene scene;

    @Override
    public void init() throws Exception {
//        Rectangle2D primaryScreen = Screen.getPrimary().getBounds();
//
//        double divideFactor = 1.5;
//
//        double sceneWidth = primaryScreen.getWidth() / divideFactor;
//        double sceneHeight = primaryScreen.getHeight() / divideFactor;
//
//        scene = new Scene(ROOT_ELEMENT, sceneWidth, sceneHeight);
//
//        initEditorGUI();
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("World editor");
//        if(scene != null) {
//            stage.setScene(scene);
//        }
//
//        stage.setFullScreen(false);

        stage.show();

        try {
            generateTestScenario();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


//        mainWindow = stage;
    }

    private void generateTestScenario() throws GeneratorException {
        Part village = new Part("village");

        village.addLayer(generateGrassLayer());

        Scenario scenario = new Scenario("test-scenario", "The name of the test scenario");

        scenario.addPart(village);

        ScenarioGenerator generator = new ScenarioGenerator("scenarios");
        generator.generate(scenario);
    }

    private Layer generateGrassLayer() {
        Asset grass = new Asset("assets/environment/floor/grass.png", 64, 64);
        Layer bgLayer = new Layer("bg", "background", grass);

        for (int i = 0; i < 40; i ++) {
            for (int j = 0; j < 40; j++) {
                bgLayer.addPosition(i * grass.getWidth(), j * grass.getHeight());
            }
        }

        return bgLayer;
    }

    private void initEditorGUI() {
        BorderPane editorWrapper = new BorderPane();
        editorWrapper.setPrefWidth(scene.getWidth());
        editorWrapper.setPrefHeight(scene.getHeight());

        HBox hBox = new HBox();

        VBox layersManager = new VBox();

        layersManager.getChildren().addAll(
                new Text("Hello layer"),
                new Text("This is second layer")
        );

        Canvas levelContent = new Canvas();
        levelContent.setWidth(200);
        levelContent.setHeight(200);

        GraphicsContext gc = levelContent.getGraphicsContext2D();
        gc.setFill(BLACK);
        gc.fillRect(0, 0, 300, 400);

        VBox propertiesManager = new VBox();

        propertiesManager.getChildren().addAll(
                new Text("Hello props"),
                new Text("This is second prop")
        );

        hBox.getChildren().addAll(layersManager, levelContent, propertiesManager);

        HBox assetsContainer = new HBox();
        assetsContainer.getChildren().addAll(
                new Text("Hello asset"),
                new Text("This is second asset")
        );
//        editorWrapper.getChildren().addAll(hBox, assetsContainer);
        editorWrapper.setCenter(levelContent);
        editorWrapper.setBottom(assetsContainer);
        ROOT_ELEMENT.getChildren().add(editorWrapper);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
