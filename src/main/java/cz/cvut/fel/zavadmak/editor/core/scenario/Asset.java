package cz.cvut.fel.zavadmak.editor.core.scenario;

import org.json.JSONObject;

public class Asset {
    private String path;
    private double width;
    private double height;

    public Asset(String path) {
        this(path, 32, 32);
    }

    public Asset(String path, double width, double height) {
        this.path = path;
        this.width = width;
        this.height = height;
    }

    public JSONObject toJSONObject() {
        JSONObject asset = new JSONObject();
        asset.put("path", path);
        JSONObject resolution = new JSONObject();
        resolution.put("width", width);
        resolution.put("height", height);
        asset.put("resolution", resolution);
        return asset;
    }
}
