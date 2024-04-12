package cz.cvut.fel.zavadmak.editor.core.scenario;

import java.util.ArrayList;

public class ScenarioPartCreator {
    private final ArrayList<Layer> layers = new ArrayList<>();
    public void addLayer(Layer layer) {
        layers.add(layer);
    }
    public Layer getLayer(String id) {
        return new Layer("test", "");
    }
}
