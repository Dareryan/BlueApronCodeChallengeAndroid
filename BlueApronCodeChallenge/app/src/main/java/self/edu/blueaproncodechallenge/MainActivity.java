package self.edu.blueaproncodechallenge;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private List<Forecast> forecastList;
    private RecyclerView recyclerView;
    private ForecastAdaptor adapter;
    private String city = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.forecast_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        final String url = "http://api.openweathermap.org/data/2.5/forecast?lat=37.33233141&lon=-122.0312186&units=imperial&APPID=56d2b582503c627add53dff05c345c34";
        new AsyncHttpTask().execute(url);
    }


    public class AsyncHttpTask extends AsyncTask<String, Void, Integer> {

        @Override
        protected Integer doInBackground(String... params) {
            InputStream inputStream = null;
            Integer result = 0;
            HttpURLConnection urlConnection = null;

            try {
                URL url = new URL(params[0]);

                urlConnection = (HttpURLConnection) url.openConnection();

                urlConnection.setRequestMethod("GET");

                int statusCode = urlConnection.getResponseCode();

                if (statusCode == 200) {

                    BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = r.readLine()) != null) {
                        response.append(line);
                    }

                    parseResult(response.toString());
                    result = 1; // Successful
                } else {
                    result = 0; //"Failed to fetch data!";
                }

            } catch (Exception e) {
                Log.d("%s", e.getLocalizedMessage());
            }

            return result;
        }

        @Override
        protected void onPostExecute(Integer result) {
            if (result == 1) {
                adapter = new ForecastAdaptor(getApplicationContext(), forecastList);
                recyclerView.setAdapter(adapter);
                getSupportActionBar().setTitle(city);
            }
        }


        private void parseResult(String result) {
            try {
                JSONObject response = new JSONObject(result);

                String cityString = (String) ((HashMap<String, String>) toMap(response).get("city")).get("name");
                if (cityString != null) {
                    city = cityString;
                }

                JSONArray posts = response.optJSONArray("list");

                if (null == forecastList) {
                    forecastList = new ArrayList<Forecast>();
                }

                for (int i = 0; i < posts.length(); i++) {
                    JSONObject post = posts.optJSONObject(i);

                    Forecast item = new Forecast(toMap(post));
                    forecastList.add(item);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public  Map<String, Object> toMap(JSONObject object) throws JSONException {
            Map<String, Object> map = new HashMap<String, Object>();

            Iterator<String> keysItr = object.keys();
            while (keysItr.hasNext()) {
                String key = keysItr.next();
                Object value = object.get(key);

                if (value instanceof JSONArray) {
                    value = toList((JSONArray) value);
                } else if (value instanceof JSONObject) {
                    value = toMap((JSONObject) value);
                }
                map.put(key, value);
            }
            return map;
        }

        public List<Object> toList(JSONArray array) throws JSONException {
            List<Object> list = new ArrayList<Object>();
            for (int i = 0; i < array.length(); i++) {
                Object value = array.get(i);
                if (value instanceof JSONArray) {
                    value = toList((JSONArray) value);
                } else if (value instanceof JSONObject) {
                    value = toMap((JSONObject) value);
                }
                list.add(value);
            }
            return list;
        }
    }

}
