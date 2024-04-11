package cz.cvut.fel.zavadmak.engine.input;

import cz.cvut.fel.zavadmak.engine.utils.Vector;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.*;

import java.util.ArrayList;
import java.util.List;

public class InputManager {
    /**
     * Keyboard key pressed
     */
    private final List<KeyCode> pressedKeys = new ArrayList<>();

    /**
     * The mouse scene position
     */
    private final Vector mousePosition = new Vector(0, 0);

    /**
     * Pressed mouse buttons
     */
    private final List<MouseButton> pressedMouseButtons = new ArrayList<>();

    /**
     * The scroll delta X axis and Y axis
     */
    private final Vector scrollDelta = new Vector(0.0, 0.0);

    private static InputManager instance;

    private InputManager() {

    }

    /**
     * Get InputManager instance
     *
     * @return InputManagerClass
     */
    public static InputManager getInstance() {
        if (instance == null) {
            instance = new InputManager();
        }
        return instance;
    }

    /**
     * Add event handlers for Scene
     *
     * @param scene the scene to which the handlers are attached
     */
    public void attach(Scene scene) {
        pressedKeys.clear();
        pressedMouseButtons.clear();
        scene.addEventHandler(KeyEvent.KEY_PRESSED, getKeyDownEventHandler());
        scene.addEventHandler(KeyEvent.KEY_RELEASED, getKeyUpEventHandler());
        scene.addEventHandler(MouseEvent.MOUSE_MOVED, getMouseMoveHandler());
        scene.addEventHandler(MouseEvent.MOUSE_PRESSED, getMouseDownHandler());
        scene.addEventHandler(MouseEvent.MOUSE_RELEASED, getMouseUpHandler());
        scene.addEventHandler(ScrollEvent.SCROLL, getScrollHandler());
    }

    /**
     * Observer for key press event
     *
     * @return EventHandler
     */
    private EventHandler<KeyEvent> getKeyDownEventHandler() {
        return (KeyEvent event) -> {
            if (!pressedKeys.contains(event.getCode())) {
                pressedKeys.add(event.getCode());
            }
        };
    }

    /**
     * Observer for key release event
     *
     * @return EventHandler
     */
    private EventHandler<KeyEvent> getKeyUpEventHandler() {
        return (KeyEvent event) -> {
            pressedKeys.remove(event.getCode());
        };
    }

    /**
     * Observer for mouse move event
     *
     * @return EventHandler
     */
    private EventHandler<MouseEvent> getMouseMoveHandler() {
        return (MouseEvent event) -> {
            mousePosition.set(event.getSceneX(), event.getSceneY());
        };
    }

    /**
     * Observer for mouse press event
     *
     * @return EventHandler
     */
    private EventHandler<MouseEvent> getMouseDownHandler() {
        return (MouseEvent event) -> {
            if (!pressedMouseButtons.contains(event.getButton())) {
                pressedMouseButtons.add(event.getButton());
            }
        };
    }

    /**
     * Observer for mouse release event
     *
     * @return EventHandler
     */
    private EventHandler<MouseEvent> getMouseUpHandler() {
        return (MouseEvent event) -> {
            pressedMouseButtons.remove(event.getButton());
        };
    }

    /**
     * Observer for scroll event
     *
     * @return EventHandler
     */
    private EventHandler<ScrollEvent> getScrollHandler() {
        return (ScrollEvent event) -> {
            scrollDelta.set(event.getDeltaX(), event.getDeltaY());
        };
    }

    /**
     * Checks keyCode if is pressed
     *
     * @param keyCode value will be checked
     * @return TRUE if key is pressed, FALSE otherwise
     */
    public boolean isKeyDown(String keyCode) {
        return pressedKeys.contains(KeyCode.valueOf(keyCode));
    }

    /**
     * Checks keyCode if is released
     *
     * @param keyCode value will be checked
     * @return TRUE if key is released, FALSE otherwise
     */
    public boolean isKeyUp(String keyCode) {
        return !isKeyDown(keyCode);
    }

    public boolean isMouseButtonDown(String mouseButton) {
        return pressedMouseButtons.contains(MouseButton.valueOf(mouseButton));
    }

    public boolean isMouseButtonUp(String mouseButton) {
        return !isMouseButtonDown(mouseButton);
    }

    public Vector getScrollDelta() {
        return scrollDelta;
    }

    public void resetScrollDelta() {
        scrollDelta.set(0, 0);
    }

    public Vector getMouseScenePosition() {
        return mousePosition;
    }
}
