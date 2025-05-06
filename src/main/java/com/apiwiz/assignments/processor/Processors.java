package com.apiwiz.assignments.processor;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public interface Processors {
    void process();
    void processFile();
    default File getFile(String path) {
        ClassLoader classLoader = PythonProcessor.class.getClassLoader();
        URL resource = classLoader.getResource(path);
        try {
            return new File(resource.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
