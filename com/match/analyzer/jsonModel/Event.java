package jsonModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Event implements Comparable<Event> {

    @JsonProperty("sport_event_id")
    private String sportEventId;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("sport_name")
    private String sportName;
    @JsonProperty("competition_name")
    private String competitionName;
    @JsonProperty("competition_id")
    private String competitionId;
    @JsonProperty("season_name")
    private String seasonName;
    private List<Competitor> competitors;
    private Venue venue;
    @JsonProperty("probability_home_team_winner")
    private double probabilityHomeTeamWinner;
    @JsonProperty("probability_draw")
    private double probabilityDraw;
    @JsonProperty("probability_away_team_winner")
    private double probabilityAwayTeamWinner;

    public Event() {
    }

    public String getSportEventId() {
        return sportEventId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getSportName() {
        return sportName;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public Venue getVenue() {
        return venue;
    }

    public double getProbabilityHomeTeamWinner() {
        return probabilityHomeTeamWinner;
    }

    public double getprobabilityDraw() {
        return probabilityDraw;
    }

    public double getProbabilityAwayTeamWinner() {
        return probabilityAwayTeamWinner;
    }

    @Override
    public int compareTo(Event o) {
        double firstValue;
        double secondValue;
        firstValue = Math.max(o.getProbabilityHomeTeamWinner(),
                o.getProbabilityAwayTeamWinner()
        );
        firstValue = Math.max(firstValue,
                o.getprobabilityDraw()
        );

        secondValue = Math.max(this.getProbabilityHomeTeamWinner(),
                this.getProbabilityAwayTeamWinner());

        secondValue = Math.max(secondValue,
                this.getprobabilityDraw());

        if (firstValue > secondValue) return 1;
        if (firstValue < secondValue) return -1;
        else return 0;
    }
}
