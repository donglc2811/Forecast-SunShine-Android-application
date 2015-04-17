package com.donglc.forecast;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {
	List<DayWeatherItem> mDayWeatherItems = new ArrayList<>();
	private ShareActionProvider mShareActionProvider;
	private ListView mLvDayWeather;
	private ImageView mImgColored;
	
	private TextView mTvHighDegree;
	private TextView mTvLowDegree;
	private TextView mTvWeatherStatus;

	private LinearLayout mLayoutToday;
	
	
	// call firstly when application to run
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initActionBar();
		initViews();
		initList();

		
		DayWeatherAdapter adapter = new DayWeatherAdapter(this,
				mDayWeatherItems, R.layout.day_weather_item);
		mLvDayWeather.setAdapter(adapter);

		DayWeatherItem today = mDayWeatherItems.get(0);
		mTvHighDegree.setText("" + today.getmHighDegree());
		mTvLowDegree.setText("" + today.getmLowDegree());
		mTvWeatherStatus.setText(today.getmStatus());
		mImgColored.setImageBitmap(today.getmColoredBitmap());

		mLvDayWeather
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						intentToDetails(position);
					}
				});

		mLayoutToday.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				intentToDetails(0);
			}
		});
	}

	// use intent to transfer data from view main application to view details.
	private void intentToDetails(int position) {
		Intent intent = new Intent(this, WeatherDetailsActivity.class);
		intent.putExtra("position", position);
		this.startActivity(intent);
		 
	}
	// initial actionbar
	private void initActionBar() {
		getSupportActionBar().setDisplayOptions(
				ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_USE_LOGO);
		getSupportActionBar().setLogo(R.drawable.ic_logo);
		getSupportActionBar().setBackgroundDrawable(
				new ColorDrawable(Color.parseColor("#FF1CA8F4")));
		
	}

	private void initViews() {
		mLvDayWeather = (ListView) findViewById(R.id.lv_dayWeather);
		mTvHighDegree = (TextView) findViewById(R.id.tv_highDegree);
		mTvLowDegree = (TextView) findViewById(R.id.tv_lowDegree);
		mTvWeatherStatus = (TextView) findViewById(R.id.tv_weatherStatus);
		mImgColored = (ImageView) findViewById(R.id.img_coloredWeather);
		mLayoutToday = (LinearLayout) findViewById(R.id.layout_today);
	}
	// set data to dayweatheritem..
	private void initList() {
		DayWeatherItem today = new DayWeatherItem(this, "Today", "Clear", 18,
				12, 81, 1017, 2);
		DayWeatherItem tomorrow = new DayWeatherItem(this, "Tomorrow",
				"Clouds", 14, 13, 81, 1017, 2);
		DayWeatherItem saturday = new DayWeatherItem(this, "Saturday", "Rain",
				14, 14, 81, 1017, 2);
		DayWeatherItem sunday = new DayWeatherItem(this, "Sunday", "Storm", 14,
				14, 81, 1017, 2);
		DayWeatherItem monday = new DayWeatherItem(this, "Monday", "Fog", 14,
				14, 81, 1017, 2);
		DayWeatherItem tuesday = new DayWeatherItem(this, "Tuesday",
				"Light Clouds", 14, 14, 81, 1017, 2);

		mDayWeatherItems.add(today);
		mDayWeatherItems.add(tomorrow);
		mDayWeatherItems.add(saturday);
		mDayWeatherItems.add(sunday);
		mDayWeatherItems.add(monday);
		mDayWeatherItems.add(tuesday);

		Utils.setDayWeatherItems(mDayWeatherItems);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);

		// Set up ShareActionProvider's default share intent
		MenuItem shareItem = menu.findItem(R.id.menu_item_share);
		mShareActionProvider = (ShareActionProvider) MenuItemCompat
				.getActionProvider(shareItem);
		mShareActionProvider.setShareIntent(getDefaultIntent());
		 
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		// noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	/**
	 * Defines a default (dummy) share intent to initialize the action provider.
	 * However, as soon as the actual content to be used in the intent is known
	 * or changes, you must update the share intent by again calling
	 * mShareActionProvider.setShareIntent()
	 */
	private Intent getDefaultIntent() {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		return intent;
	}
}
