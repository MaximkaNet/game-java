package cz.cvut.fel.zavadmak.engine.material;

import javafx.scene.image.Image;

public class Material extends Image {
    public Material(String filename) {
        super(filename);
    }
    public Material (String filename, double width, double height, boolean preserveRation, boolean smooth) {
        super(filename, width, height, preserveRation, smooth);
    }
}
