package jsonModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SportEvent {

    private @JsonProperty("Events") List<Event> eventList;

    public List<Event> getEventsList() {
        return eventList;
    }

    public SportEvent(List<Event> eventList) {
        this.eventList = eventList;
    }

    public SportEvent() {
    }
}
