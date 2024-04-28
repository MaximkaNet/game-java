package cz.cvut.fel.zavadmak.editor.scenario;

import cz.cvut.fel.zavadmak.editor.exception.GeneratorException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.logging.Logger;

public class ScenarioGenerator {
    private final String scenariosPath;

    private static final Logger logger = Logger.getLogger(ScenarioGenerator.class.getName());

    public ScenarioGenerator(String scenariosPath) {
        this.scenariosPath = scenariosPath;
    }

    /**
     * Generate scenario file structure
     *
     * @param scenario Scenario to generate
     * @throws GeneratorException
     */
    public void generate(Scenario scenario) throws GeneratorException {
        String pathToScenarioRoot = scenariosPath + "/" + scenario.getId().toLowerCase();
        createDirsIfNotExists(pathToScenarioRoot);

        // Generate scenario meta ...
        JSONObject jsonMeta = new JSONObject();
        jsonMeta.put("id", scenario.getId());
        jsonMeta.put("name", scenario.getName());
        jsonMeta.put("description", scenario.getDescription());
        try {
            Files.writeString(Path.of(pathToScenarioRoot + "/meta.json"), jsonMeta.toString(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            GeneratorException generatorException = new GeneratorException(e.getMessage());
            generatorException.setStackTrace(e.getStackTrace());
            throw generatorException;
        }
        // Generate scenario parts ...
        String pathToParts = pathToScenarioRoot + "/parts";
        createDirsIfNotExists(pathToParts);
        Collection<Part> parts = scenario.getParts().values();
        try {
            for (Part part : parts) {
                Files.writeString(Path.of(pathToParts + "/" + part.getName("json")), part.generateJSON().toString());
            }
        } catch (Exception e) {
            GeneratorException generatorException = new GeneratorException(e.getMessage());
            generatorException.setStackTrace(e.getStackTrace());
            throw generatorException;
        }
    }

    private void createDirsIfNotExists(String path) {
        try {
            Files.createDirectories(Path.of(path));
        } catch (Exception e) {
            logger.info("Directories '" + path + "' already exists.");
        }
    }
}
