package cz.cvut.fel.zavadmak.engine.scenario;

public class ScenarioMeta {
    private String title;
    private String description;

    public ScenarioMeta() {
        this("", "");
    }

    public ScenarioMeta(String title) {
        this(title, "");
    }

    public ScenarioMeta(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
