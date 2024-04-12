package cz.cvut.fel.zavadmak.magic_adventure.views.components;

import cz.cvut.fel.zavadmak.engine.material.Material;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class HealthPoints extends HBox {

    /**
     * Maximum number of health points
     */
    private int maxPoints = 0;

    /**
     * Current number of health points
     */
    private int count = 0;

    /**
     * Health point image
     */
    private Material image;

    public HealthPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public HealthPoints(String pathToImage, int maxPoints) {
        image = new Material(pathToImage, 32, 32, true, true);
        this.maxPoints = maxPoints;
    }

    /**
     * Add one health point
     */
    public void addPoint() {
        if (this.count < maxPoints - 1) {
            this.count += 1;
            if (image != null) {
                this.getChildren().add(new ImageView(image));
            }
        }
    }

    /**
     * Remove one health point
     */
    public void removePoint() {
        if (this.count > 0) {
            this.count -= 1;
            this.getChildren().remove(this.getChildren().size() - 1);
        }
    }

    /**
     * Add n points
     * @param n Number of points that will be added
     */
    public void addPoints(int n) {
        for (int i = 0; i < n; i++) {
            addPoint();
        }
    }

    /**
     * Remove n points
     * @param n Number of point that will be removed
     */
    public void removePoints(int n) {
        for (int i = 0; i < n; i++) {
            removePoint();
        }
    }
}
