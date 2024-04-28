package cz.cvut.fel.zavadmak.engine.utils;

import java.net.URL;

public class Resources {
    /**
     * Checks resource exists
     *
     * @param path path to resource
     * @return TRUE if exists, FALSE otherwise
     */
    public static boolean exists(String path) {
        return Resources.class.getClassLoader().getResource(path) != null;
    }

    /**
     * Get resource url
     *
     * @param path relative resource path
     * @return URL to resource
     */
    public static URL getResourceURL(String path) {
        return Resources.class.getClassLoader().getResource(path);
    }
}
