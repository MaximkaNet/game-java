package cz.cvut.fel.zavadmak.editor.scenario;

import cz.cvut.fel.zavadmak.engine.utils.Vector;
import org.json.JSONObject;

public class SpawnPoint {
    private final Vector point;
    private final String who;
    public SpawnPoint(String who, Vector point) {
        this.who = who;
        this.point = point;
    }
    public SpawnPoint(String who, double x, double y) {
        this(who, new Vector(x, y));
    }

    public String getWho() {
        return who;
    }

    public JSONObject toJSONObject() {
        JSONObject jsonPoint = new JSONObject();
        jsonPoint.put("x", point.getX());
        jsonPoint.put("y", point.getY());

        JSONObject jsonSpawnPoint = new JSONObject();
        jsonSpawnPoint.put("who", who);
        jsonSpawnPoint.put("point", jsonPoint);
        return jsonSpawnPoint;
    }
}
