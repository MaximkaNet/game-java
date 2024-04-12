package cz.cvut.fel.zavadmak.magic_adventure.views;

import cz.cvut.fel.zavadmak.engine.ViewController;
import cz.cvut.fel.zavadmak.magic_adventure.ViewManager;

/**
 * View interface
 */
public interface View {
    /**
     * Set view manager reference
     * @param viewManager Reference to ViewManager
     */
    void setViewManagerRef(ViewManager viewManager);

    /**
     * Get view manager reference
     * @return ViewManager
     */
    ViewManager getViewManager();

    /**
     * Get attached view controller
     * @return ViewController
     */
    ViewController getControllerRef();

    /**
     * Get view title
     * @return String
     */
    String getTitle();
}
