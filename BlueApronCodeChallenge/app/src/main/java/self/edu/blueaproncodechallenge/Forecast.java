package self.edu.blueaproncodechallenge;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;

import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Dare on 1/12/16.
 */
public class Forecast {

    private Date date = new Date();
    private String weatherDescription = "";
    private String  weatherIconID = "";
    private String location = "";
    private Double currentTemp = 0.0;
    private Double minimumTemp = 0.0;
    private Double maximumTemp = 0.0;


    public Forecast(Dictionary response) {

        String date = (String) response.get("dt");
        if(date != null) {
            this.date = new Date(Long.parseLong(date) * 1000);
        }

        List weather = (List<Dictionary<String, ?>>) response.get("weather");
        String description = (String)((Dictionary<String, ?>) weather.get(0)).get("description");
        if(description != null) {
            this.weatherDescription = description;
        }

        String iconID = (String) response.get("icon");
        if (iconID != null) {
            this.weatherIconID = iconID;
        }

        Dictionary<String, String> tempDict = (Dictionary<String, String>) response.get("main");
        if(tempDict != null) {
            this.minimumTemp = Double.valueOf(tempDict.get("temp_min");
            this.maximumTemp = Double.valueOf(tempDict.get("temp_max"));
            this.currentTemp = Double.valueOf(tempDict.get("temp"));
        }
    }


    public Drawable weatherIcon() {
        return drawableForWeatherIconID(weatherIconID);
    }

    public String weatherDescription() {
        return this.weatherDescription;
    }

    public  String headerText() {
        String date = new SimpleDateFormat("MMMM dd").format(this.date);
        return String.format("%s  %s", date, this.location);
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

    private static Drawable drawableForWeatherIconID(String id) {
        switch (id) {
            case "01d":
                return Resources.getSystem().getDrawable(R.drawable.image_01d, null);
            case "02d":
                return Resources.getSystem().getDrawable(R.drawable.image_02d, null);
            case "03d":
                return Resources.getSystem().getDrawable(R.drawable.image_03d, null);
            case "04d":
                return Resources.getSystem().getDrawable(R.drawable.image_04d, null);
            case "09d":
                return Resources.getSystem().getDrawable(R.drawable.image_09d, null);
            case "10d":
                return Resources.getSystem().getDrawable(R.drawable.image_10d, null);
            case "11d":
                return Resources.getSystem().getDrawable(R.drawable.image_11d, null);
            case "13d":
                return Resources.getSystem().getDrawable(R.drawable.image_13d, null);
            case "50d":
                return Resources.getSystem().getDrawable(R.drawable.image_50d, null);
            case "01n":
                return Resources.getSystem().getDrawable(R.drawable.image_01n, null);
            case "02n":
                return Resources.getSystem().getDrawable(R.drawable.image_02n, null);
            case "03n":
                return Resources.getSystem().getDrawable(R.drawable.image_03n, null);
            case "04n":
                return Resources.getSystem().getDrawable(R.drawable.image_04n, null);
            case "09n":
                return Resources.getSystem().getDrawable(R.drawable.image_09n, null);
            case "10n":
                return Resources.getSystem().getDrawable(R.drawable.image_10n, null);
            case "11n":
                return Resources.getSystem().getDrawable(R.drawable.image_11n, null);
            case "13n":
                return Resources.getSystem().getDrawable(R.drawable.image_13n, null);
            case "50n":
                return Resources.getSystem().getDrawable(R.drawable.image_50n, null);
            default:
                return Resources.getSystem().getDrawable(R.drawable.image_01d, null);
        }
    }

}
