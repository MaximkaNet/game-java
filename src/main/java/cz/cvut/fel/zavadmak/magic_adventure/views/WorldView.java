package cz.cvut.fel.zavadmak.magic_adventure.views;

import cz.cvut.fel.zavadmak.engine.ViewController;
import cz.cvut.fel.zavadmak.magic_adventure.ViewManager;
import cz.cvut.fel.zavadmak.magic_adventure.controllers.WorldController;
import cz.cvut.fel.zavadmak.magic_adventure.views.components.HealthPoints;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public final class WorldView extends Scene implements View {
    /**
     * Reference to view manager
     */
    private ViewManager viewManagerRef;

    /**
     * The reference to view controller
     */
    private final WorldController controllerRef;

    /**
     * The view title
     */
    private final String title = "Magic Adventure";

    /**
     * The canvas for rendering
     */
    private final Canvas renderProvider = new Canvas();
    private final HealthPoints healthPoints = new HealthPoints("assets/interface/hp.png", 10);
    private final BorderPane worldUI = new BorderPane();

    public WorldView(WorldController controller) {
        // Init root node
        super(new Group());
        controllerRef = controller;
        // Get root node from this view
        Group root = (Group) getRoot();
        root.getChildren().add(renderProvider);
        root.getChildren().add(worldUI);

        worldUI.autosize();
        worldUI.setLeft(healthPoints);
        healthPoints.addPoints(10);
        worldUI.setPadding(new Insets(20));

        setSizeHandlersForRenderProvider();
    }

    /**
     * Set listeners for width and height properties for renderProvider(Canvas)
     */
    private void setSizeHandlersForRenderProvider() {
        this.widthProperty().addListener((invalidation) -> {
            // Get readonly property
            ReadOnlyDoubleProperty property = (ReadOnlyDoubleProperty) invalidation;
            // Set value for the renderProvider
            renderProvider.setWidth(property.doubleValue());
        });
        this.heightProperty().addListener((invalidation) -> {
            // Get readonly property
            ReadOnlyDoubleProperty property = (ReadOnlyDoubleProperty) invalidation;
            // Set value for the renderProvider
            renderProvider.setHeight(property.doubleValue());
        });
    }

    /**
     * Get render provider (Canvas)
     * @return Canvas
     */
    public Canvas getRenderProvider() {
        return renderProvider;
    }

    @Override
    public void setViewManagerRef(ViewManager viewManager) {
         this.viewManagerRef = viewManager;
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
