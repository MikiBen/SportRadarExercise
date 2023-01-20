package team;

import jsonModel.SportEvent;

import java.util.Set;
import java.util.TreeSet;

public class Team {

    private Set<String> uniqueTeamNames = new TreeSet<>();
    private SportEvent sportEvent;

    public Team(SportEvent sportEvent) {
        this.sportEvent = sportEvent;
    }

    public void addUniqueTeamNames() {
        for (int i = 0; i < sportEvent.getEventsList().size(); i++) {
            uniqueTeamNames.add(sportEvent.getEventsList().get(i).getCompetitors().get(0).getName());
            uniqueTeamNames.add(sportEvent.getEventsList().get(i).getCompetitors().get(1).getName());
        }
    }

    public void showUniqueTeamNames() {
        System.out.println("Competitors names sorted in alphabetical order: ");
        for (String name : uniqueTeamNames) {
            System.out.println(name);
        }
    }

}
