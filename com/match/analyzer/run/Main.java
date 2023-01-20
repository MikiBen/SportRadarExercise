package run;

import tools.MatchAnalyzer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        new MatchAnalyzer("com/match/resources/BE_data.json").analyze();

    }
}