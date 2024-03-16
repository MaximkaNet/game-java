package cz.cvut.fel.zavadmak.core;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public interface InputManagerInterface {

    /**
     * Get key event handler for KEY_PRESSED event
     * @return EventHandler
     */
    EventHandler<KeyEvent> getEventKeyPressed();

    /**
     * Get key event handler for KEY_RELEASE event
     * @return EventHandler
     */
    EventHandler<KeyEvent> getEventKeyReleased();

    /**
     * Check key pressed
     * @param key
     * @return TRUE if key pressed, FALSE otherwise
     */
    boolean getKey(String key);

    /**
     * Check if key is pressed
     *
     * @param key
     * @return TRUE is key is pressed
     */
    boolean keyPressed(String key);

    /**
     * Check if key is released
     *
     * @param key
     * @return TRUE is key is released
     */
    boolean keyReleased(String key);

}
