package cz.cvut.fel.zavadmak.editor.scenario;

import cz.cvut.fel.zavadmak.editor.exception.InvalidLayerException;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;

public class Part {
    private final HashMap<String, Layer> layers = new HashMap<>();
    private final HashMap<String, SpawnPoint> spawnPoints = new HashMap<>();

    /**
     * Add new layer to scenario. If layer id already exists
     * in scenario layers, layer will be replaced.
     *
     * @param layer The layer
     */
    public void addLayer(Layer layer) {
        layers.put(layer.getId(), layer);
    }

    /**
     * Get layer by id
     *
     * @param id the layer id
     * @return Returns Layer if it was found, NULL otherwise
     */
    public Layer getLayer(String id) {
        return layers.get(id);
    }

    /**
     * Add new spawn point to scenario part. If spawn point already exists in scenario part,
     * spawn point will be replaced
     *
     * @param spawnPoint The SpawnPoint
     */
    public void addSpawnPoint(SpawnPoint spawnPoint) {
        spawnPoints.put(spawnPoint.getWho(), spawnPoint);
    }

    public String generate() throws InvalidLayerException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("spawn_points", generateSpawnPoints());
        jsonObject.put("layers", generateLayers());
        return jsonObject.toString();
    }

    public JSONArray generateLayers() throws InvalidLayerException {
        JSONArray jsonArray = new JSONArray();
        for (Layer l : layers.values()) {
            jsonArray.put(l.toJSONObject());
        }
        return jsonArray;
    }

    public JSONArray generateSpawnPoints() {
        JSONArray jsonSpawnPoints = new JSONArray();
        for (SpawnPoint sp : spawnPoints.values()) {
            jsonSpawnPoints.put(sp.toJSONObject());
        }
        return jsonSpawnPoints;
    }
}
