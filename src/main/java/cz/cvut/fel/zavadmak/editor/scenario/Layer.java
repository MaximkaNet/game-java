package cz.cvut.fel.zavadmak.editor.core.scenario;

import cz.cvut.fel.zavadmak.editor.core.exception.InvalidLayerException;
import cz.cvut.fel.zavadmak.engine.utils.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Layer {
    private final String id;
    private final String name;
    private final Asset asset;
    private final ArrayList<Vector> positions = new ArrayList<>();

    public Layer(String id, String name) {
        this(id, name, null);
    }

    public Layer(String id, String name, Asset asset) {
        this.id = id;
        this.name = name;
        this.asset = asset;
    }

    public void addPosition(double x, double y) {
        positions.add(new Vector(x, y));
    }

    public void addPosition(Vector pos) {
        positions.add(pos);
    }

    /**
     * Check all important values for layer
     *
     * @return TRUE if all values is set, FALSE if at least one is not correct
     */
    public boolean isValid() {
        return !id.isEmpty() && !name.isEmpty() && asset != null;
    }

    public JSONObject toJSONObject() throws InvalidLayerException {
        if (!isValid() || !asset.isValidPath())
            throw new InvalidLayerException();
        JSONObject layer = new JSONObject();
        layer.put("id", id);
        layer.put("name", name);
        layer.put("asset", asset.toJSONObject());
        JSONArray jsonPositions = new JSONArray();
        for (Vector point : positions) {
            jsonPositions.put(new JSONObject("{\"x\": " + point.getX() + ", \"y\": " + point.getY() + "}"));
        }
        layer.put("positions", jsonPositions);
        return layer;
    }
}
