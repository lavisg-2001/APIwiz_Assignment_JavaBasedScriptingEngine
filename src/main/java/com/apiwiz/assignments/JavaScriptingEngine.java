package com.apiwiz.assignments;

import com.apiwiz.assignments.processor.JavaEngineFactory;

public class JavaScriptingEngine {
    public static void main(String[] args) {
        JavaEngineFactory.run("js").process();
        JavaEngineFactory.run("js").processFile();
        JavaEngineFactory.run("py").process();
        JavaEngineFactory.run("py").processFile();
    }
}

