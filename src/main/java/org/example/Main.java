package org.example;

import file.JsonFile;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        JsonFile jsonFile = new JsonFile();

        jsonFile.readFile();
        jsonFile.showMostProbableResult(5);
    }
}