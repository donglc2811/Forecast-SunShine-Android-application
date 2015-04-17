package com.donglc.forecast;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class WeatherDetailsActivity extends ActionBarActivity {
    private TextView mTvHighDegree;
    private TextView mTvLowDegree;
    private TextView mTvHumidity;
    private TextView mTvPressure;
    private TextView mTvWind;
    private TextView mTvDay;
    private TextView mTvWeatherStatus;
    private ImageView mImgColoredWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_details);

        initActionBar();
        initViews();

        int position = getIntent().getIntExtra("position", 0);
        DayWeatherItem item = Utils.getDayWeatherItems().get(position);
        mTvDay.setText(item.getmDay());
        mTvHighDegree.setText("" + item.getmHighDegree());
        mTvLowDegree.setText("" + item.getmLowDegree());
        mTvHumidity.setText("" + item.getmHumidity());
        mTvPressure.setText("" + item.getmPressure());
        mTvWind.setText("" + item.getmWind());
        mTvWeatherStatus.setText(item.getmStatus());
        mImgColoredWeather.setImageBitmap(item.getmColoredBitmap());
    }

    private void initViews() {
        mTvHighDegree = (TextView) findViewById(R.id.tv_highDegree);
        mTvLowDegree = (TextView) findViewById(R.id.tv_lowDegree);
        mTvHumidity = (TextView) findViewById(R.id.tv_humidity);
        mTvPressure = (TextView) findViewById(R.id.tv_pressure);
        mTvWind = (TextView) findViewById(R.id.tv_wind);
        mTvDay = (TextView) findViewById(R.id.tv_day);
        mTvWeatherStatus = (TextView) findViewById(R.id.tv_weatherStatus);
        mImgColoredWeather = (ImageView) findViewById(R.id.img_coloredWeather);
    }

    private void initActionBar() {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_USE_LOGO);
        getSupportActionBar().setLogo(R.drawable.ic_logo);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF1CA8F4")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
            case android.R.id.home:
                   finish();

            }
            return true;
    }
}
