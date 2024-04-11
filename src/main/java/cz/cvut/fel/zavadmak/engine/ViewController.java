package cz.cvut.fel.zavadmak.engine;

public interface ViewController {

    /**
     * Start controller handling
     */
    void startHandling();

    /**
     * Shutdown controller
     */
    void shutdownController();
}
