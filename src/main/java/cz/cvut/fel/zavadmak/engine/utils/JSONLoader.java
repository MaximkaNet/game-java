package cz.cvut.fel.zavadmak.engine.utils;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONLoader {
    public static JSONObject load(String pathToFile) throws Exception {
        String fullFileContent = Files.readString(Paths.get(pathToFile));
        return new JSONObject(fullFileContent);
    }
}
