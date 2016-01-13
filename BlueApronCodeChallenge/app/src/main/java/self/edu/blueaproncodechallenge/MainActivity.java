package self.edu.blueaproncodechallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private List<Forecast> forecastList;
    private RecyclerView recyclerView;
    private ForecastAdaptor adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.forecast_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ForecastAdaptor(getApplicationContext(), getData());
        recyclerView.setAdapter(adapter);
    }

    public static List<Forecast> getData() {
        List<Forecast> data = new ArrayList<>();

        Map<String, Object> forecastResponse = Forecast.fakeForecastDictionary();
        Forecast forecast = new Forecast(forecastResponse);
        Forecast forecast2 = new Forecast(forecastResponse);
        data.add(forecast);
        data.add(forecast2);

        return data;
    }
}
