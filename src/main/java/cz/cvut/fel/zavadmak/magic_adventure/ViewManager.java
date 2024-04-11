package cz.cvut.fel.zavadmak.magic_adventure;

import cz.cvut.fel.zavadmak.engine.input.InputManager;
import cz.cvut.fel.zavadmak.magic_adventure.views.View;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewManager {
    /**
     * The attached stage
     */
    private Stage stage;

    /**
     * Current view
     */
    private View currentView;

    public ViewManager(Stage stage) {
        this.stage = stage;
        stage.setResizable(false);
    }

    /**
     * Attach stage to manager
     *
     * @param stage The stage for attach
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Set view as scene for stage
     */
    public void setCurrentView(View view) throws Exception {
        if(view == null) {
            System.err.println("View cannot be null");
            return;
        }
        if (stage == null) {
            System.err.println("Stage is not defined. Please attach stage to manager");
            return;
        }
        if(currentView != null) {
            // Shutdown controller
            currentView.getControllerRef().shutdownController();
        }
        // Set new view
        currentView = view;
        // Attach input manager to the view
        InputManager.getInstance().attach((Scene) currentView);
        // Start the current view controller
        currentView.getControllerRef().startHandling();

        stage.setTitle(currentView.getTitle());
        stage.setScene((Scene) currentView);
    }

    /**
     * Current view
     * @return View
     */
    public View getCurrentView() {
        return currentView;
    }

    /**
     * The function checks if there is a reference for the stage
     *
     * @return TRUE if ViewManager has Stage, FALSE otherwise
     */
    public boolean hasStage() {
        return stage != null;
    }
}
