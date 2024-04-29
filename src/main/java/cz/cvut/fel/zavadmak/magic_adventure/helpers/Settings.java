package cz.cvut.fel.zavadmak.magic_adventure.helpers;

import cz.cvut.fel.zavadmak.engine.utils.JSONLoader;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class Settings {
    private String playerNickname;
    private final HashMap<Controls, String> controls = new HashMap<>();

    public enum Controls {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public void setDefault() {
        controls.put(Controls.UP, "W");
        controls.put(Controls.DOWN, "S");
        controls.put(Controls.LEFT, "A");
        controls.put(Controls.RIGHT, "D");
    }

    public String getPlayerNickname() {
        return playerNickname;
    }

    public String getControlKey(Controls controlKey) {
        return controls.get(controlKey);
    }

    public void setControl(Controls controlKey, String key) {
        controls.put(controlKey, key);
    }

    /**
     * Load settings from file
     *
     * @param filename the settings file
     * @return True if settings are loaded, False otherwise
     */
    public boolean load(String filename) {
        try {
            JSONObject loaded = JSONLoader.load(filename);
            JSONObject jsonControls = loaded.getJSONObject("controls");
            JSONObject jsonPlayer = loaded.getJSONObject("player");
            playerNickname = jsonPlayer.getString("nickname");

            controls.put(Controls.UP, jsonControls.getString(Controls.UP.name().toLowerCase()));
            controls.put(Controls.DOWN, jsonControls.getString(Controls.DOWN.name().toLowerCase()));
            controls.put(Controls.LEFT, jsonControls.getString(Controls.LEFT.name().toLowerCase()));
            controls.put(Controls.RIGHT, jsonControls.getString(Controls.RIGHT.name().toLowerCase()));
            return true;
        } catch (Exception e) {
            setDefault();
            return false;
        }
    }

    /**
     * Save settings to file
     *
     * @param filename the settings file
     * @throws IOException throws if file was not write
     */
    public void save(String filename) throws IOException {
        JSONObject jsonControls = new JSONObject();
        jsonControls.put(Controls.UP.name().toLowerCase(), controls.getOrDefault(Controls.UP, "W"));
        jsonControls.put(Controls.DOWN.name().toLowerCase(), controls.getOrDefault(Controls.DOWN, "S"));
        jsonControls.put(Controls.LEFT.name().toLowerCase(), controls.getOrDefault(Controls.LEFT, "A"));
        jsonControls.put(Controls.RIGHT.name().toLowerCase(), controls.getOrDefault(Controls.RIGHT, "D"));

        JSONObject jsonPlayer = new JSONObject();
        jsonPlayer.put("nickname", playerNickname);

        JSONObject jsonSettings = new JSONObject();
        jsonSettings.put("controls", jsonControls);
        jsonSettings.put("player", jsonPlayer);

        Files.writeString(Path.of(filename), jsonSettings.toString());
    }
}
