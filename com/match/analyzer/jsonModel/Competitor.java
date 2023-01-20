package jsonModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Competitor {

    private String id;
    private String name;
    private String country;
    @JsonProperty("country_code")
    private String countryCode;
    private String abbreviation;
    private String qualifier;
    private String gender;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCountry_code() {
        return countryCode;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getQualifier() {
        return qualifier;
    }

    public String getGender() {
        return gender;
    }
}

