package cz.cvut.fel.zavadmak.magic_adventure.views;

import cz.cvut.fel.zavadmak.engine.ViewController;
import cz.cvut.fel.zavadmak.magic_adventure.ViewManager;
import cz.cvut.fel.zavadmak.magic_adventure.controllers.StartController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

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
    private final String title = "Magic adventure";

    Button newGameButton = new Button("New game");
    Button showScenariosButton = new Button("Scenarios");
    Button settingsButton = new Button("Settings");
    Button exitButton = new Button("Exit");

    public StartView(StartController controller) {
        super(new Group());
        this.controllerRef = controller;
        Group root = (Group) getRoot();
        root.getChildren().add(newGameButton);
        newGameButton.setOnAction((event) -> {
            try {
                viewManagerRef.setCurrentView(ViewList.WORLD.getView());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
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
