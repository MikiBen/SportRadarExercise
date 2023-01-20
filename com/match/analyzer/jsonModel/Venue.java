package jsonModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Venue {
    private String id;
    private String name;
    private int capacity;
    @JsonProperty("city_name")
    private String cityName;
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("map_coordinates")
    private String mapCoordinates;
    @JsonProperty("country_code")
    private String countryCode;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getMapCoordinates() {
        return mapCoordinates;
    }

    public String getCountry_code() {
        return countryCode;
    }
}
