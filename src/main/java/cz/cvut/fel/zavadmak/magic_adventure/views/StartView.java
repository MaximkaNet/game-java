package cz.cvut.fel.zavadmak.magic_adventure.views;

import cz.cvut.fel.zavadmak.engine.ViewController;
import cz.cvut.fel.zavadmak.magic_adventure.ViewManager;
import cz.cvut.fel.zavadmak.magic_adventure.controllers.StartController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * The main page where you can select a new game world,
 * change settings, and load the saved progress for the
 * selected world.
 */
public final class StartView extends Scene implements View {
    /**
     * ViewManager reference
     */
    private ViewManager viewManagerRef;

    /**
     * Reference to controller
     */
    private StartController controllerRef;

    /**
     * The view title
     */
    private String title;



    public StartView(StartController controller) {
        this("Start", controller);
    }

    public StartView(String title, StartController controller) {
        super(new AnchorPane());
        this.title = title;
        this.controllerRef = controller;
        this.getStylesheets().add("assets/styles/start-view.css");
        init();
    }

    public void init() {
        Button newGameButton = new Button("New game");
        Button showScenariosButton = new Button("Scenarios");
        Button settingsButton = new Button("Settings");
        Button exitButton = new Button("Exit");

        newGameButton.getStyleClass().add("menu__button");
        showScenariosButton.getStyleClass().add("menu__button");
        settingsButton.getStyleClass().add("menu__button");
        exitButton.getStyleClass().add("menu__button");

        VBox vBox = new VBox();
        vBox.getChildren().addAll(newGameButton, showScenariosButton, settingsButton, exitButton);
        vBox.setAlignment(Pos.BOTTOM_LEFT);

        AnchorPane.setBottomAnchor(vBox, 40.0);
        AnchorPane.setLeftAnchor(vBox, 60.0);

        Label title = new Label("Magic adventure");
        title.getStyleClass().add("menu__title");

        AnchorPane.setTopAnchor(title, 60.0);
        this.widthProperty().addListener((event) -> {
            AnchorPane.setLeftAnchor(title, (this.widthProperty().get() / 2) - (title.getWidth() / 2));
        });
        ((AnchorPane) this.getRoot()).getChildren().addAll(vBox, title);
    }

    @Override
    public void setViewManagerRef(ViewManager viewManager) {
        viewManagerRef = viewManager;
    }

    @Override
    public ViewManager getViewManager() {
        return viewManagerRef;
    }

    @Override
    public ViewController getControllerRef() {
        return controllerRef;
    }

    @Override
    public String getTitle() {
        return this.title;
    }
}
