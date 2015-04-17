package com.donglc.forecast;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static List<DayWeatherItem> dayWeatherItems = new ArrayList<>();

    public static List<DayWeatherItem> getDayWeatherItems() {
        return dayWeatherItems;
    }

    public static void setDayWeatherItems(List<DayWeatherItem> dayWeatherItems) {
        Utils.dayWeatherItems = dayWeatherItems;
    }
}
