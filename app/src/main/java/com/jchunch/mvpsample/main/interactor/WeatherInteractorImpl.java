package com.jchunch.mvpsample.main.interactor;

import android.os.Handler;

import com.jchunch.mvpsample.model.Weather;
import com.jchunch.mvpsample.main.presenter.WeatherResponseListener;

import java.util.Random;

/**
 * Created by john.hunchar on 1/23/17.
 */

public class WeatherInteractorImpl implements WeatherInteractor {

    private final WeatherResponseListener listener;

    public WeatherInteractorImpl(WeatherResponseListener listener) {
        this.listener = listener;
    }

    @Override
    public void fetchWeather() {

        // Replace this with actual network call
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Weather weather = null;
                if (new Random().nextBoolean()) {
                    weather = new Weather();
                    weather.setDescription("Cloudy skies early will become partly cloudy later at night. Slight chance of a rain shower. Low 34F. Winds light and variable.");
                    weather.setHeadline("Clouds early/clearing late");
                    weather.setTemperature("42");
                }
                listener.onDataResponse(weather);
            }
        }, 1500);
    }
}
