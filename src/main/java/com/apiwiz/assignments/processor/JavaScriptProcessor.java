package com.apiwiz.assignments.processor;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JavaScriptProcessor implements Processors {
    @Override
    public void process() {
        System.out.println("Processing Javascript Engin with Raw Script");
        try (Context context = Context.create()) {
            String script = "var result = 20 + 20; result;";
            Value result = context.eval("js", script);
            System.out.println("JavaScript execution result: " + result.asInt());
        }
    }

    @Override
    public void processFile() {
        System.out.println("Processing Javascript Engin with File");
        StringBuilder scriptContent = new StringBuilder();
        try (Context context = Context.create();
             BufferedReader reader = new BufferedReader(new FileReader(getFile("test.js")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                scriptContent.append(line).append("\n");
            }
            Value result = context.eval("js", scriptContent);
            System.out.println("Script Output:");
            System.out.println(result.asInt());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
