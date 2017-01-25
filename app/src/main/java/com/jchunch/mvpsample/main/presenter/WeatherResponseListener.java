package com.jchunch.mvpsample.main.presenter;

import com.jchunch.mvpsample.model.Weather;

/**
 * Created by john.hunchar on 1/23/17.
 */

public interface WeatherResponseListener {
    void handleWeatherResponse(Weather weather);
}
