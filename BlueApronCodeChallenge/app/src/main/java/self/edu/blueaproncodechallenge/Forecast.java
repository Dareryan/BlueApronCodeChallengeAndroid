package self.edu.blueaproncodechallenge;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;

import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Dare on 1/12/16.
 */
public class Forecast {

    private Date date = new Date();
    private String weatherDescription = "";
    private String  weatherIconID = "";
    private Double currentTemp = 0.0;
    private Double minimumTemp = 0.0;
    private Double maximumTemp = 0.0;



    public Forecast(Map response) {

        Long date = Long.valueOf(response.get("dt").toString());
        if(date != null) {
            this.date = new Date(date * 1000);
        }

        List weather = (List<Map<String, Object>>) response.get("weather");
        String description = (String)((Map<String, Object>) weather.get(0)).get("description");
        if(description != null) {
            this.weatherDescription = description;
        }

        String iconID = (String) response.get("icon");
        if (iconID != null) {
            this.weatherIconID = iconID;
        }

        Map<String, Double> tempDict = (Map<String, Double>) response.get("main");
        if(tempDict != null) {
            this.minimumTemp = (tempDict.get("temp_min"));
            this.maximumTemp = (tempDict.get("temp_max"));
            this.currentTemp = (tempDict.get("temp"));
        }
    }

    public static Map fakeForecastDictionary() {
        Map<String, Object> forecast = new HashMap<>();
        forecast.put("dt",  1452654000);

        Map<String, String> weatherMap = new HashMap<>();
        weatherMap.put("description", "Sunny");
        ArrayList<Map<String, String>> weatherList = new ArrayList<Map<String, String>>();
        weatherList.add(weatherMap);
        forecast.put("weather", weatherList);

        forecast.put("icon", "01d");

        Map<String, String> tempDict = new HashMap<>();
        tempDict.put("temp_min", "98.442");
        tempDict.put("temp_max", "100.256");
        tempDict.put("temp", "95.334");

        forecast.put("main", tempDict);

        return forecast;
    }

    public String weatherIcon() {
        return weatherIconID;
    }

    public String weatherDescription() {
        return this.weatherDescription;
    }

    public  String headerText() {
        String date = new SimpleDateFormat("MMMM dd").format(this.date);
        return date;
    }

    public String currentTemp() {
        return String.format("%.1f", this.currentTemp);
    }

    public String minTemp() {
        return String.format("%.1f", this.minimumTemp);
    }

    public String maxTemp() {
        return String.format("%.1f", this.maximumTemp);
    }
}
