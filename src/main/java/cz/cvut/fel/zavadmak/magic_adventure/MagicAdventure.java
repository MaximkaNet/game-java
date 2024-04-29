package cz.cvut.fel.zavadmak.magic_adventure;

import cz.cvut.fel.zavadmak.magic_adventure.controllers.WorldController;
import cz.cvut.fel.zavadmak.magic_adventure.views.ViewList;
import cz.cvut.fel.zavadmak.magic_adventure.views.WorldView;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Main application. Entry point to application
 */
public class MagicAdventure extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Set window settings
        Rectangle2D screen = Screen.getPrimary().getBounds();
        primaryStage.setWidth(screen.getWidth() / 1.5);
        primaryStage.setHeight(screen.getHeight() / 1.5);
        primaryStage.setResizable(false);

        // Create the new view manager
        ViewManager viewManager = new ViewManager(primaryStage);
        // Add references to view manager
//        ViewList.WORLD.getView().setViewManagerRef(viewManager);
        ViewList.START.getView().setViewManagerRef(viewManager);
        // Set current view

//        WorldView worldView = (WorldView) ViewList.WORLD.getView();
//        // Initialize world controller
//        WorldController worldController = (WorldController) ViewList.WORLD.getView().getControllerRef();
//        // Load player data
//        worldController.loadPlayer();
//        // Load save data
//        String part = worldController.loadSave("first-scenario-save-0");
//        // Load scenario part from save
//        worldController.loadWorld("first-scenario", part);
//        worldController.setGraphicsContext(worldView.getRenderProvider().getGraphicsContext2D());

        // Set current view
//        viewManager.setCurrentView(ViewList.WORLD.getView());
        viewManager.setCurrentView(ViewList.START.getView());

        // Show window
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
