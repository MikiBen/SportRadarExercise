package jsonModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SportEvents {

    private @JsonProperty("Events") List<Events> eventsList;

    public List<Events> getEventsList() {
        return eventsList;
    }

    public SportEvents(List<Events> eventsList) {
        this.eventsList = eventsList;
    }

    public SportEvents() {
    }
}
