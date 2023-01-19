package file;

import com.fasterxml.jackson.databind.ObjectMapper;
import jsonModel.SportEvents;
import team.Teams;

import java.io.IOException;
import java.util.Collections;

public class JsonFile {
    private SportEvents sportEvents;

    public SportEvents getSport() {
        return sportEvents;
    }

    public void readFile() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        sportEvents = objectMapper.readValue(new java.io.File("BE_data.json"), SportEvents.class);
        sortingCollection();
    }

    public void showUniqueTeamNames(){
        Teams teams = new Teams(sportEvents);
       teams.addUniqueTeamNames();
       teams.showUniqueTeamNames();
    }

    private void sortingCollection(){
        Collections.sort(sportEvents.getEventsList());
    }

    public void showMostProbableResult(int n){

        n = checkSizeParameter(n, sportEvents.getEventsList().size());

        for(int i =0; i<n ;i++)
        {
            System.out.println("Start date: " + refactorDate(sportEvents.getEventsList().get(i).getStart_date())+ ",");
            System.out.println(sportEvents.getEventsList().get(i).getCompetitors().get(0).getName() + " (" +
                                sportEvents.getEventsList().get(i).getCompetitors().get(0).getCountry() +  ") vs " +
                                sportEvents.getEventsList().get(i).getCompetitors().get(1).getName() + " (" +
                                sportEvents.getEventsList().get(i).getCompetitors().get(1).getCountry() + "),");
            System.out.println("Venue: " + checkNull(i) + ",");
            System.out.println(findHighValue(i));
        }
    }

    private String checkNull(int n){

        if(sportEvents.getEventsList().get(n).getVenue() == null ) return "";
        else return sportEvents.getEventsList().get(n).getVenue().getName();

    }
    private int checkSizeParameter(int parameter, int listSize){

        if(parameter> listSize){
            System.out.println("You enetered too large parameter, We do not have that many records. \n " +
                    "We will display all records. ");
            return listSize;
        }else{
            return parameter;
        }
    }

    private String findHighValue(int i){
        String result = "DRAW";
        Double value = Double.valueOf(sportEvents.getEventsList().get(i).getProbability_draw());

        if(sportEvents.getEventsList().get(i).getProbability_home_team_winner()>
                value){
            result = "HOME_TEAM_WIN";
            value = Double.valueOf(sportEvents.getEventsList().get(i).getProbability_home_team_winner());

            if(sportEvents.getEventsList().get(i).getProbability_away_team_winner()>value){

                result = "AWAY_TEAM_WIN";
                value = Double.valueOf(sportEvents.getEventsList().get(i).getProbability_away_team_winner());
            }
        }else{
            if(sportEvents.getEventsList().get(i).getProbability_away_team_winner()>value){

                result = "AWAY_TEAM_WIN";
                value = Double.valueOf(sportEvents.getEventsList().get(i).getProbability_away_team_winner());
            }
        }
        return "Highest probable result: " + result + " (" + value.doubleValue() + ")\n";
    }

    private String refactorDate (String s){

        s = s.replaceFirst("T", " ");
        s = s.substring(0, 19);

        return s;
    }
}
