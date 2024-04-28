package cz.cvut.fel.zavadmak.editor.exception;

public class InvalidLayerException extends Exception {
    public InvalidLayerException(String msg) {
        super(msg);
    }
    public InvalidLayerException() {
        super("Layers properties is not filled or not valid");
    }
}
