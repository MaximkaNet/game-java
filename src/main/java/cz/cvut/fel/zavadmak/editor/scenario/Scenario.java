package cz.cvut.fel.zavadmak.editor.scenario;

import java.util.HashMap;

public class Scenario {
    private final String id;
    private final String name;
    private String description;
    private final HashMap<String, Part> parts = new HashMap<>();

    public Scenario(String id, String name) {
        this(id, name, "");
    }

    public Scenario(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public HashMap<String, Part> getParts() {
        return parts;
    }

    public void addPart(Part part) {
        parts.put(part.getName().toLowerCase(), part);
    }
}
