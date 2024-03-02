package cz.cvut.fel.zavadmak.core;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

/**
 * Input manager<br/>
 * Singleton
 */
public class InputManager implements InputManagerInterface {
    private static InputManager instance;

    /**
     * Keyboard input values
     */
    private final ArrayList<String> keyboard = new ArrayList<>();

    private InputManager() {
    }

    /**
     * Get manager instance
     *
     * @return InputManager instance
     */
    public static InputManager getInstance() {
        if (instance == null) {
            instance = new InputManager();
        }
        return instance;
    }

    @Override
    public EventHandler<KeyEvent> getEventKeyPressed() {
        return event -> {
            if (!keyboard.contains(event.getCode().toString())) {
                keyboard.add(event.getCode().toString());
            }
        };
    }

    @Override
    public EventHandler<KeyEvent> getEventKeyReleased() {
        return event -> {
            keyboard.remove(event.getCode().toString());
        };
    }

    @Override
    public boolean getKey(String key) {
        return keyboard.contains(key);
    }

    @Override
    public boolean keyPressed(String key) {
        return keyboard.contains(key);
    }

    @Override
    public boolean keyReleased(String key) {
        return !keyboard.contains(key);
    }
}
