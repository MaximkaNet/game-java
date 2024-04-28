package cz.cvut.fel.zavadmak.editor.scenario;

import cz.cvut.fel.zavadmak.engine.utils.Resources;
import org.json.JSONObject;

/**
 * The asset to be saved in scenario
 * Standard asset resolution is 32x32 px
 */
public class Asset {

    /**
     * Path to asset
     */
    private final String path;
    private double width;
    private double height;

    public Asset(String path) {
        this(path, 32, 32);
    }

    public Asset(String pathToResource, double width, double height) {
        this.path = pathToResource;
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String getPath() {
        return path;
    }

    /**
     * Check exists path
     *
     * @return TRUE if file exists, FALSE if file not exists or path is empty
     */
    public boolean exists() {
        return Resources.exists(path);
    }

    /**
     * Change asset resolution
     *
     * @param newWidth  the asset width
     * @param newHeight the asset height
     */
    public void changeResolution(double newWidth, double newHeight) {
        width = newWidth;
        height = newHeight;
    }

    public JSONObject toJSONObject() {
        JSONObject jsonResolution = new JSONObject();
        jsonResolution.put("width", width);
        jsonResolution.put("height", height);

        JSONObject jsonAsset = new JSONObject();
        jsonAsset.put("path", path);
        jsonAsset.put("resolution", jsonResolution);
        return jsonAsset;
    }
}
