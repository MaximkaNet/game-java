package cz.cvut.fel.zavadmak.engine.scenario;

import cz.cvut.fel.zavadmak.engine.utils.JSONLoader;
import org.json.JSONArray;
import org.json.JSONObject;

public class ScenarioHelper {
    private final String scenariosFolder;
    private final String scenario;
    private JSONObject jsonScenarioPart;
    private JSONObject jsonScenarioMeta;

    public ScenarioHelper(String scenariosFolder, String scenario) {
        this.scenario = scenario;
        this.scenariosFolder = scenariosFolder;
    }

    /**
     * Load the scenario meta
     *
     * @return TRUE if meta loaded, FALSE if not loaded
     */
    public boolean loadMeta() {
        try {
            String pathToMetaFile = scenariosFolder + "/" + scenario + "/meta.json";
            jsonScenarioMeta = JSONLoader.load(pathToMetaFile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Load the scenario part
     *
     * @param part The part name
     * @return TRUE if loaded, FALSE if not loaded
     */
    public boolean loadPart(String part) {
        try {
            String pathToPartFile = scenariosFolder + "/" + scenario + "/parts/" + part + ".json";
            jsonScenarioPart = JSONLoader.load(pathToPartFile);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println(e.getStackTrace().toString());
            return false;
        }
    }

    /**
     * Get meta data from meta.json
     *
     * @return ScenarioMeta - the transfer object
     */
    public ScenarioMeta getMeta() {
        if (jsonScenarioMeta == null) {
            System.err.println("Scenario meta not loaded");
            return null;
        }
        return new ScenarioMeta(jsonScenarioMeta.getString("title"),
                jsonScenarioMeta.getString("description"));
    }

    /**
     * Get layers from loaded json
     * @return JSONArray
     */
    public JSONArray getLayers() {
        return jsonScenarioPart.getJSONArray("layers");
    }
}
