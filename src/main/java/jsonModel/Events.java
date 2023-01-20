package jsonModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Events implements Comparable<Events>{

    private @JsonProperty("sport_event_id") String sport_event_id;
    private String start_date;
    private String sport_name;
    private String competition_name;
    private String competition_id;
    private String season_name;
    private List<Competitors> competitors;
    private Venue venue;
    private double probability_home_team_winner;
    private double probability_draw;
    private double probability_away_team_winner;

    public Events(String sport_event_id, String start_date, String sport_name, String competition_name, String competition_id, String season_name, List<Competitors> competitors, Venue venue, int probability_home_team_winner, int probability_draw, int probability_away_team_winner) {
        this.sport_event_id = sport_event_id;
        this.start_date = start_date;
        this.sport_name = sport_name;
        this.competition_name = competition_name;
        this.competition_id = competition_id;
        this.season_name = season_name;
        this.competitors = competitors;
        this.venue = venue;
        this.probability_home_team_winner = probability_home_team_winner;
        this.probability_draw = probability_draw;
        this.probability_away_team_winner = probability_away_team_winner;
    }

    public Events() {
    }

    public String getSport_event_id() {
        return sport_event_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getSport_name() {
        return sport_name;
    }

    public String getCompetition_name() {
        return competition_name;
    }

    public String getCompetition_id() {
        return competition_id;
    }

    public String getSeason_name() {
        return season_name;
    }

    public List<Competitors> getCompetitors() {
        return competitors;
    }

    public Venue getVenue() {
        return venue;
    }

    public double getProbability_home_team_winner() {
        return probability_home_team_winner;
    }

    public double getProbability_draw() {
        return probability_draw;
    }

    public double getProbability_away_team_winner() {
        return probability_away_team_winner;
    }

    @Override
    public int compareTo(Events o) {
        double firstValue;
        double secondValue;
        firstValue = Math.max(o.getProbability_home_team_winner(),
                o.getProbability_away_team_winner()
        );
        firstValue = Math.max(firstValue,
                o.getProbability_draw()
        );

        secondValue = Math.max(this.getProbability_home_team_winner(),
                this.getProbability_away_team_winner());

        secondValue = Math.max(secondValue,
                this.getProbability_draw());

        if(firstValue>secondValue) return 1;
        if(firstValue<secondValue) return -1;
        else return 0;
    }
}
