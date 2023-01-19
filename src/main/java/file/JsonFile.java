package file;

import com.fasterxml.jackson.databind.ObjectMapper;
import jsonModel.SportEvents;

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

    private void sortingCollection(){
        Collections.sort(sportEvents.getEventsList());
    }

    public void showMostProbableResult(int n){
        for(int i =0; i<n;i++)
        {
            System.out.println(sportEvents.getEventsList().get(i).getStart_date());
            System.out.println(sportEvents.getEventsList().get(i).getCompetitors().get(0).getName());
            System.out.println(sportEvents.getEventsList().get(i).getCompetitors().get(1).getName());
            System.out.println(sportEvents.getEventsList().get(i).getVenue().getName());
            System.out.println(findHighValue(i));
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
        return "Highest probable result: " + result + " (" + value + ")\n";
    }
}
