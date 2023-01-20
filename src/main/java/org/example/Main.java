package org.example;

import file.JsonFile;
import other.ReadParameter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        JsonFile jsonFile = new JsonFile();
        ReadParameter readParameter = new ReadParameter();

        jsonFile.readFile();
        jsonFile.showMostProbableResult(readParameter.readLine());
        jsonFile.showUniqueTeamNames();
    }
}