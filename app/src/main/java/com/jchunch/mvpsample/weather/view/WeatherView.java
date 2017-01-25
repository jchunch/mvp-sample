package com.jchunch.mvpsample.weather.view;

import com.jchunch.mvpsample.model.Weather;

import java.util.List;

/**
 * Created by john.hunchar on 1/23/17.
 */

public interface WeatherView {
    void displayContent(String description, String headline, String temperature);
    void displayErrorState();
    void displayLoadingState();
}
