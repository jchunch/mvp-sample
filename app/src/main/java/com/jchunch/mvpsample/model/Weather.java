package com.jchunch.mvpsample.model;

/**
 * Created by john.hunchar on 1/23/17.
 */

public class Weather {

    private String description;
    private String headline;
    private String temperature;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
