package team;

import jsonModel.SportEvents;

import java.util.Set;
import java.util.TreeSet;

public class Teams {

    private Set<String> uniqueTeamNames = new TreeSet<>();
    private SportEvents sportEvents;

    public Teams(SportEvents sportEvents) {
        this.sportEvents = sportEvents;
    }

    public void addUniqueTeamNames(){
        for(int i=0; i<sportEvents.getEventsList().size();i++){
            uniqueTeamNames.add(sportEvents.getEventsList().get(i).getCompetitors().get(0).getName());
            uniqueTeamNames.add(sportEvents.getEventsList().get(i).getCompetitors().get(1).getName());
        }
    }

    public void showUniqueTeamNames(){
        System.out.println("Competitors names sorted in alphabetical order: ");
        for(String name:uniqueTeamNames){
            System.out.println(name);
        }
    }

}
