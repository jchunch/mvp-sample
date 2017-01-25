package com.jchunch.mvpsample.main.presenter;

import com.jchunch.mvpsample.model.Weather;
import com.jchunch.mvpsample.main.interactor.WeatherInteractor;
import com.jchunch.mvpsample.main.interactor.WeatherInteractorImpl;
import com.jchunch.mvpsample.main.view.WeatherView;

/**
 * Created by john.hunchar on 1/23/17.
 */

public class WeatherPresenterImpl implements WeatherPresenter, WeatherResponseListener {

    private Weather weather;
    private final WeatherInteractor interactor;
    private final WeatherView view;

    public WeatherPresenterImpl(WeatherView view) {
        interactor = new WeatherInteractorImpl(this);
        this.view = view;
    }

    @Override
    public void onDataResponse(Weather weather) {
        this.weather = weather;

        if (weather == null) {
            view.displayErrorState();
        } else {
            view.displayContent(
                    weather.getDescription(),
                    weather.getHeadline(),
                    weather.getTemperature());
        }
    }

    @Override
    public void refreshData() {
        requestData();
    }

    @Override
    public void startPresenting() {
        if (weather == null) {
            requestData();
        } else {
            view.displayContent(
                    weather.getDescription(),
                    weather.getHeadline(),
                    weather.getTemperature());
        }
    }

    private void requestData() {
        view.displayLoadingState();
        interactor.fetchWeather();
    }
}
