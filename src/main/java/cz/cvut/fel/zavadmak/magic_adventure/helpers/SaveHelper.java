package cz.cvut.fel.zavadmak.magic_adventure.helpers;

import cz.cvut.fel.zavadmak.engine.material.Material;
import cz.cvut.fel.zavadmak.engine.utils.JSONLoader;
import cz.cvut.fel.zavadmak.engine.utils.Vector;
import cz.cvut.fel.zavadmak.magic_adventure.domain.Player;
import org.json.JSONObject;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class SaveHelper {
    private final String savesFolder;
    private final String saveName;
    private JSONObject jsonScenarioSave;
    private JSONObject jsonSaveMeta;
    private JSONObject jsonPlayer;
    private final HashMap<String, JSONObject> parts = new HashMap<>();

    public SaveHelper(String savesFolder, String saveName) {
        this.savesFolder = savesFolder;
        this.saveName = saveName;
    }

    /**
     * Load save parts
     *
     * @return TRUE if loaded, FALSE otherwise
     */
    public boolean load() {
        try {
            String pathToSave = savesFolder + "/" + saveName;
            jsonPlayer = JSONLoader.load(pathToSave + "/player.json");
            // Get parts
            File dir = new File(pathToSave + "/parts");
            FilenameFilter filter = (directory, name) -> name.endsWith(".json");
            for (File part : dir.listFiles(filter)) {
                String partFilename = part.getName();
                // Get filename without extension
                String partName = partFilename.substring(partFilename.indexOf(".json"));
                // Load json
                parts.put(partName, JSONLoader.load(part.getPath()));
            }
            return true;
        } catch (Exception e) {
            // Log ...
            return false;
        }
    }

    /**
     * Get data about player from save
     *
     * @return Player
     */
    public PlayerMeta getPlayer() {
        String currentPart = jsonPlayer.getString("part");
        JSONObject jsonWorldPos = jsonPlayer.getJSONObject("world_position");
        Vector worldPos = new Vector(jsonWorldPos.getDouble("x"), jsonWorldPos.getDouble("y"));
        // Set meta
        PlayerMeta playerMeta = new PlayerMeta();
        playerMeta.setScenarioPart(currentPart);
        playerMeta.setWorldPosition(worldPos);
        return playerMeta;
    }
}
