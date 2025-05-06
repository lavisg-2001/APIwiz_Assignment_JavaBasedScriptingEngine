package com.apiwiz.assignments.processor;

import java.util.Map;

public class JavaEngineFactory {

    private static Map<String, Processors> processorsMap;

    static {
        processorsMap = Map.of(
                "js", new JavaScriptProcessor(),
                "py", new PythonProcessor()
        );
    }

    public static Processors run(String language) {
        return processorsMap.getOrDefault(language, new Processors() {
            @Override
            public void process() {
                System.out.println("Language not supported: " + language);
            }

            @Override
            public void processFile() {
                System.out.println("Language not supported: " + language);
            }
        });
    }
}
