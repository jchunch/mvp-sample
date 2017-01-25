package com.jchunch.mvpsample.weather.presenter;

import com.jchunch.mvpsample.model.Weather;

import java.util.List;

/**
 * Created by john.hunchar on 1/23/17.
 */

public interface WeatherResponseListener {
    void onDataResponse(Weather weather);
}
