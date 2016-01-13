package self.edu.blueaproncodechallenge;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;


/**
 * Created by Dare on 1/12/16.
 */
public class ForecastAdaptor extends RecyclerView.Adapter<ForecastAdaptor.ForecastViewHolder>{

    private LayoutInflater inflater;
    List<Forecast> data = Collections.emptyList();
    private Context context;

    public ForecastAdaptor(Context context, List<Forecast> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_forecast_cell, parent,false);

        ForecastViewHolder holder = new ForecastViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {

        Forecast forecast = data.get(position);
        holder.imageView.setImageDrawable(drawableForWeatherIconID(forecast.weatherIcon()));
        holder.forecastDescription.setText(forecast.weatherDescription());
        holder.headerTextView.setText(forecast.headerText());
        holder.currentTempTextView.setText(forecast.currentTemp());
        holder.lowTempTextView.setText(forecast.minTemp());
        holder.highTempTextView.setText(forecast.maxTemp());
    }

    @Override
    public int getItemCount() {
        return (null != data ? data.size() : 0);
    }

    class ForecastViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView forecastDescription;
        TextView headerTextView;
        TextView currentTempTextView;
        TextView lowTempTextView;
        TextView highTempTextView;

        public ForecastViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.forecastImageView);
            forecastDescription = (TextView) itemView.findViewById(R.id.forecastDescriptionTextView);
            headerTextView = (TextView) itemView.findViewById(R.id.titleTextView);
            currentTempTextView = (TextView) itemView.findViewById(R.id.currentTempTextView);
            highTempTextView = (TextView) itemView.findViewById(R.id.maxTempTextView);
            lowTempTextView = (TextView) itemView.findViewById(R.id.minTempTextView);
        }
    }

    private Drawable drawableForWeatherIconID(String id) {
        switch (id) {
            case "01d":
                return context.getDrawable(R.drawable.image_01d);
            case "02d":
                return context.getDrawable(R.drawable.image_02d);
            case "03d":
                return context.getDrawable(R.drawable.image_03d);
            case "04d":
                return context.getDrawable(R.drawable.image_04d);
            case "09d":
                return context.getDrawable(R.drawable.image_09d);
            case "10d":
                return context.getDrawable(R.drawable.image_10d);
            case "11d":
                return context.getDrawable(R.drawable.image_11d);
            case "13d":
                return context.getDrawable(R.drawable.image_13d);
            case "50d":
                return context.getDrawable(R.drawable.image_50d);
            case "01n":
                return context.getDrawable(R.drawable.image_01n);
            case "02n":
                return context.getDrawable(R.drawable.image_02n);
            case "03n":
                return context.getDrawable(R.drawable.image_03n);
            case "04n":
                return context.getDrawable(R.drawable.image_04n);
            case "09n":
                return context.getDrawable(R.drawable.image_09n);
            case "10n":
                return context.getDrawable(R.drawable.image_10n);
            case "11n":
                return context.getDrawable(R.drawable.image_11n);
            case "13n":
                return context.getDrawable(R.drawable.image_13n);
            case "50n":
                return context.getDrawable(R.drawable.image_50n);
            default:
                return context.getDrawable(R.drawable.image_01d);
        }

    }
}


