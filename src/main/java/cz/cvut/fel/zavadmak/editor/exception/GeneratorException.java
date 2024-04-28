package cz.cvut.fel.zavadmak.editor.exception;

public class GeneratorException extends Exception {
    public GeneratorException(String msg) {
        super("Exception in generator: " + msg);
    }
}
