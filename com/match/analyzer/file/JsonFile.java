package file;

import com.fasterxml.jackson.databind.ObjectMapper;
import jsonModel.SportEvent;
import team.Team;

import java.io.IOException;
import java.util.Collections;

public class JsonFile {
    private SportEvent sportEvent;

    public SportEvent getSport() {
        return sportEvent;
    }

    public void readFile(String pathName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        sportEvent = objectMapper.readValue(new java.io.File(pathName), SportEvent.class);
        sortingCollection();
    }

    public void showUniqueTeamNames() {
        Team team = new Team(sportEvent);
        team.addUniqueTeamNames();
        team.showUniqueTeamNames();
    }

    private void sortingCollection() {
        Collections.sort(sportEvent.getEventsList());
    }

    public void showMostProbableResult(int n) {

        n = checkSizeParameter(n, sportEvent.getEventsList().size());

        for (int i = 0; i < n; i++) {
            System.out.println("Start date: " + refactorDate(sportEvent.getEventsList().get(i).getStartDate()) + ",");
            System.out.println(sportEvent.getEventsList().get(i).getCompetitors().get(0).getName() + " (" +
                    sportEvent.getEventsList().get(i).getCompetitors().get(0).getCountry() + ") vs " +
                    sportEvent.getEventsList().get(i).getCompetitors().get(1).getName() + " (" +
                    sportEvent.getEventsList().get(i).getCompetitors().get(1).getCountry() + "),");
            System.out.println("Venue: " + checkNull(i) + ",");
            System.out.println(findHighValue(i));
        }
    }

    private String checkNull(int n) {

        if (sportEvent.getEventsList().get(n).getVenue() == null) return "";
        else return sportEvent.getEventsList().get(n).getVenue().getName();

    }

    private int checkSizeParameter(int parameter, int listSize) {

        if (parameter > listSize) {
            System.out.println("You entered too large parameter, We do not have that many records. \n " +
                    "We will display all records. ");
            return listSize;
        } else {
            return parameter;
        }
    }

    private String findHighValue(int i) {

        if (sportEvent.getEventsList().get(i).getProbabilityHomeTeamWinner() >= sportEvent.getEventsList().get(i).getprobabilityDraw() &&
                sportEvent.getEventsList().get(i).getProbabilityHomeTeamWinner() >= sportEvent.getEventsList().get(i).getProbabilityAwayTeamWinner()) {
            return "Highest probable result: HOME_TEAM_WIN (" + sportEvent.getEventsList().get(i).getProbabilityHomeTeamWinner() + ")\n";
        } else if (sportEvent.getEventsList().get(i).getProbabilityAwayTeamWinner() >= sportEvent.getEventsList().get(i).getprobabilityDraw() &&
                sportEvent.getEventsList().get(i).getProbabilityAwayTeamWinner() >= sportEvent.getEventsList().get(i).getProbabilityHomeTeamWinner()) {
            return "Highest probable result: AWAY_TEAM_WIN (" + sportEvent.getEventsList().get(i).getProbabilityAwayTeamWinner() + ")\n";
        } else {
            return "Highest probable result: DRAW (" + sportEvent.getEventsList().get(i).getprobabilityDraw() + ")\n";
        }
    }

    private String refactorDate(String s) {

        s = s.replaceFirst("T", " ");
        s = s.substring(0, 19);
        return s;
    }

}
