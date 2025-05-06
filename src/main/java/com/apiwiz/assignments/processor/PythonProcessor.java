package com.apiwiz.assignments.processor;

import javax.script.*;
import java.io.*;

public class PythonProcessor implements Processors {
    private ScriptEngine getEngine() {
        ScriptEngineManager manager = new ScriptEngineManager();
        return manager.getEngineByName("python");
    }

    @Override
    public void process() {
        System.out.println("Processing Python Engin with Raw Script");
        try {
            StringWriter writer = new StringWriter();
            ScriptContext context = new SimpleScriptContext();
            context.setWriter(writer);
            String script = """
                    def add(a, b):
                        return a + b
                    
                    result = add(10, 20)
                    print(result)
                    """;
            getEngine().eval(script, context);

            System.out.println("Script Output:\n" + writer);
        } catch (NullPointerException | ScriptException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void processFile() {
        System.out.println("Processing Python Engin with File");
        try {
            StringWriter writer = new StringWriter();
            ScriptContext context = new SimpleScriptContext();
            context.setWriter(writer);
            context.setErrorWriter(writer);
            try (FileReader reader = new FileReader(getFile("test.py"))) {
                getEngine().eval(reader, context);
                System.out.println("Script Output:");
                System.out.println(writer);
            }
        } catch (NullPointerException | ScriptException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
