package tools;

import file.JsonFile;

import java.io.IOException;

public class MatchAnalyzer {

    String pathName;
    JsonFile jsonFile = new JsonFile();
    ReadParameter readParameter = new ReadParameter();

    public MatchAnalyzer(String pathName) {
        this.pathName = pathName;
    }

    public void analyze() throws IOException {

        jsonFile.readFile(pathName);
        jsonFile.showMostProbableResult(readParameter.readLine());
        jsonFile.showUniqueTeamNames();
    }
}
