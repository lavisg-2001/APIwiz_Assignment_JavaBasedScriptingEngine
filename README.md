# Java-based Scripting Engine Utility

## Overview

This project provides a **Java-based scripting engine** that allows dynamic execution of **JavaScript** and **Python** scripts within the Java Virtual Machine (JVM), returning results as Java objects. The engine supports raw script execution as well as script execution from files, all without relying on external command-line tools. It also enables the use of libraries in both scripting languages, offering a flexible interface for script evaluation.

### Key Features:
- Execute **JavaScript** and **Python** scripts within the JVM.
- Supports both **raw scripts** and **file-based script execution**.
- Uses **GraalVM Polyglot** for JavaScript execution and **Java's ScriptEngine** for Python.
- Returns results as Java objects.
- Supports third-party libraries for both scripting languages.

## Table of Contents

- [Overview](#overview)
- [Structure](#structure)
- [Components](#components)
    - [JavaEngineFactory](#1-javaenginefactory)
    - [JavaScriptProcessor](#2-javascriptprocessor)
    - [PythonProcessor](#3-pythonprocessor)
    - [Processors Interface](#4-processors-interface)
    - [JavaScriptingEngine](#5-javascriptingengine)
- [Design Pattern](#design-pattern)
- [Usage](#usage)
- [Dependencies](#dependencies)
- [Conclusion](#conclusion)

## Structure

The project is organized into the following packages:
- `com.apiwiz.assignments.processor`: Contains the logic for executing JavaScript and Python scripts.
- `com.apiwiz.assignments`: Contains the main application that runs the scripting engine.

### 1. **JavaEngineFactory**

This factory class returns the appropriate processor based on the scripting language (`js` or `py`). It supports a simple language-to-processor mapping.

- `run(String language)`: Returns a processor for the given language. If the language is unsupported, it returns an error message.

### 2. **JavaScriptProcessor**

Handles JavaScript execution using **GraalVM Polyglot** to evaluate scripts.

- `process()`: Executes a raw JavaScript script.
- `processFile()`: Executes a JavaScript script from a file.

### 3. **PythonProcessor**

Handles Python script execution using **Java's ScriptEngine**.

- `process()`: Executes a raw Python script.
- `processFile()`: Executes a Python script from a file.

### 4. **Processors Interface**

Defines methods that both the `JavaScriptProcessor` and `PythonProcessor` implement:

- `process()`: Executes a raw script.
- `processFile()`: Executes a script from a file.
- `getFile(String path)`: Retrieves a file from the classpath (default method).

### 5. **JavaScriptingEngine**

The main class that runs the entire engine, using `JavaEngineFactory` to select the appropriate processor and execute both raw and file-based scripts.

## Design Patterns

This project utilizes the following design patterns:

* **Factory Pattern**: The `JavaEngineFactory` class implements the Factory pattern to create instances of processors (JavaScript and Python processors) based on the requested language. This allows for easy extension to support additional languages in the future.

* **Strategy Pattern**: The `Processors` interface defines a strategy for processing scripts. The `JavaScriptProcessor` and `PythonProcessor` classes implement this interface, allowing the main application to execute different processing strategies based on the language.

## Usage

1. **Add Scripts**: You can either use raw script content or add script files (`test.js` for JavaScript or `test.py` for Python) to the project.
2. **Run the Application**:

    ```bash
    java -cp target/your-artifact-name.jar com.apiwiz.assignments.JavaScriptingEngine
    ```

## Dependencies

- **GraalVM** for JavaScript execution using the Polyglot API.
- **Java's ScriptEngine** for Python execution (available in Java's standard library).

## Conclusion

This utility provides a lightweight solution for executing JavaScript and Python scripts within the JVM. It supports both raw and file-based script execution, integrates external libraries, and demonstrates the power of **GraalVM** and **Java's scripting capabilities**. Whether for integrating dynamic scripting into Java applications or running small scripts, this engine offers a flexible and efficient solution.

