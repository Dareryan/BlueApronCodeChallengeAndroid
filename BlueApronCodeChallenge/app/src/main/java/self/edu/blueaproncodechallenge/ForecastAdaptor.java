package self.edu.blueaproncodechallenge;

import android.app.Activity;
import android.content.Context;
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

    public ForecastAdaptor(Context context, List<Forecast> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.view_forecast_cell, parent, false);
        ForecastViewHolder holder = new ForecastViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {

        Forecast forecast = data.get(position);

        holder.imageView.setImageDrawable(forecast.weatherIcon());
        holder.forecastDescription.setText(forecast.weatherDescription());
        holder.headerTextView.setText(forecast.headerText());
        holder.currentTempTextView.setText(forecast.currentTemp());
        holder.lowTempTextView.setText(forecast.minTemp());
        holder.highTempTextView.setText(forecast.maxTemp());
    }

    @Override
    public int getItemCount() {
        return data.size();
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
}


