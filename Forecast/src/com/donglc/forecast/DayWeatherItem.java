package com.donglc.forecast;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class DayWeatherItem {
    private String mDay;
    private Bitmap mNoneColoredBitmap;
    private Bitmap mColoredBitmap;
    private String mStatus;
    private int mHighDegree;
    private int mLowDegree;
    private int mHumidity;
    private int mPressure;
    private int mWind;

    // Constructor
    public DayWeatherItem(Context context, String mDay, String mStatus, int mHighDegree, int mLowDegree, int mHumidity, int mPressure, int mWind) {
        this.mDay = mDay;
        this.mStatus = mStatus;
        this.mHighDegree = mHighDegree;
        this.mLowDegree = mLowDegree;
        this.mHumidity = mHumidity;
        this.mPressure = mPressure;
        this.mWind = mWind;

         
        
        //set icon corresponding with the icon in res/drawable
        switch (mStatus) {
            case "Clear":
                setmNoneColoredBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_clear));
                setmColoredBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.art_clear));
                break;
            case "Clouds":
                setmNoneColoredBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_cloudy));
                setmColoredBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.art_clouds));
                break;
            case "Rain":
                setmNoneColoredBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_rain));
                setmColoredBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.art_rain));
                break;
            case "Storm":
                setmNoneColoredBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_storm));
                setmColoredBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.art_storm));
                break;
            case "Fog":
                setmNoneColoredBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_fog));
                setmColoredBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.art_fog));
                break;
            case "Light Clouds":
                setmNoneColoredBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_light_clouds));
                setmColoredBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.art_light_clouds));
                break;
            case "Light Rain":
                setmNoneColoredBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_light_rain));
                setmColoredBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.art_light_rain));
                break;
            case "Snow":
                setmNoneColoredBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_snow));
                setmColoredBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.art_snow));
                break;
        }
    }

	public String getmDay() {
		return mDay;
	}

	public void setmDay(String mDay) {
		this.mDay = mDay;
	}

	public Bitmap getmNoneColoredBitmap() {
		return mNoneColoredBitmap;
	}

	public void setmNoneColoredBitmap(Bitmap mNoneColoredBitmap) {
		this.mNoneColoredBitmap = mNoneColoredBitmap;
	}

	public Bitmap getmColoredBitmap() {
		return mColoredBitmap;
	}

	public void setmColoredBitmap(Bitmap mColoredBitmap) {
		this.mColoredBitmap = mColoredBitmap;
	}

	public String getmStatus() {
		return mStatus;
	}

	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}

	public int getmHighDegree() {
		return mHighDegree;
	}

	public void setmHighDegree(int mHighDegree) {
		this.mHighDegree = mHighDegree;
	}

	public int getmLowDegree() {
		return mLowDegree;
	}

	public void setmLowDegree(int mLowDegree) {
		this.mLowDegree = mLowDegree;
	}

	public int getmHumidity() {
		return mHumidity;
	}

	public void setmHumidity(int mHumidity) {
		this.mHumidity = mHumidity;
	}

	public int getmPressure() {
		return mPressure;
	}

	public void setmPressure(int mPressure) {
		this.mPressure = mPressure;
	}

	public int getmWind() {
		return mWind;
	}

	public void setmWind(int mWind) {
		this.mWind = mWind;
	}

     
}
