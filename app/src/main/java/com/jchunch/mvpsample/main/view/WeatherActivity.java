package com.jchunch.mvpsample.main.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.jchunch.mvpsample.base.BaseActivity;
import com.jchunch.mvpsample.R;
import com.jchunch.mvpsample.main.presenter.WeatherPresenter;
import com.jchunch.mvpsample.main.presenter.WeatherPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherActivity extends BaseActivity implements WeatherView {

    private WeatherPresenter presenter;

    @BindView(R.id.weather_text_view_description)
    TextView description;

    @BindView(R.id.weather_text_view_headline)
    TextView headline;

    @BindView(R.id.weather_text_view_temperature)
    TextView temperature;

    @BindView(R.id.weather_view_flipper)
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        // Create presenter
        presenter = new WeatherPresenterImpl(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Start presenter
        presenter.startPresenting();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_weather_refresh:
                presenter.handleRefreshMenuItemClick();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }

    @Override
    public void displayContent(String description, String headline, String temperature) {
        this.description.setText(description);
        this.headline.setText(headline);
        this.temperature.setText(String.format(getString(R.string.temperature), temperature));
        setViewFlipperChildByResId(viewFlipper, R.id.weather_view_group_content);
    }

    @Override
    public void displayErrorState() {
        setViewFlipperChildByResId(viewFlipper, R.id.weather_view_group_error);
    }

    @Override
    public void displayLoadingState() {
        setViewFlipperChildByResId(viewFlipper, R.id.weather_view_group_loading);
    }
}
