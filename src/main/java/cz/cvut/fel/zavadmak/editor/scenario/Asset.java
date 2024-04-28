package cz.cvut.fel.zavadmak.editor.core.scenario;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * The asset to be saved in scenario
 * Standard asset resolution is 32x32 px
 */
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

    /**
     * Check exists path
     * @return TRUE if file exists, FALSE if file not exists or path is empty
     */
    public boolean isValidPath() {
        if (path.isEmpty())
            return false;
        return Files.exists(Path.of(path));
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
