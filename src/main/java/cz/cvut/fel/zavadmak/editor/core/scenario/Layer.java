package cz.cvut.fel.zavadmak.editor.core.scenario;

import cz.cvut.fel.zavadmak.engine.utils.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Layer {
    private final String name;
    private Asset asset;
    private final ArrayList<Vector> positions = new ArrayList<>();

    public Layer(String name, String pathToAsset) {
        this.name = name;
        this.asset = new Asset(pathToAsset);
    }

    public void addPosition(double x, double y) {
        positions.add(new Vector(x, y));
    }
    public void addPosition(Vector pos) {
        positions.add(pos);
    }

    public JSONObject toJSONObject() {
        JSONObject layer = new JSONObject();
        layer.put("name", name);
        layer.put("asset", new JSONObject());
        JSONArray jsonPositions = new JSONArray();
        for (Vector point : positions) {
            jsonPositions.put(new JSONObject("{\"x\": " + point.getX() + ", \"y\": " + point.getY() + "}"));
        }
        layer.put("positions", new JSONArray());
        return layer;
    }
}
