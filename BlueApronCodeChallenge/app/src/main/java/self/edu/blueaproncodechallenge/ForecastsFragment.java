package self.edu.blueaproncodechallenge;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Dare on 1/12/16.
 */

public class ForecastsFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_forecasts, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.forecastRecyclerView);
        return layout;
    }


}
