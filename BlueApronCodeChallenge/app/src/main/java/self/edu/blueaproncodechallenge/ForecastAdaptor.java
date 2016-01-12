package self.edu.blueaproncodechallenge;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Dare on 1/12/16.
 */
public class ForecastAdaptor extends RecyclerView.Adapter<ForecastAdaptor.ForecastViewHolder>{
    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ForecastViewHolder extends RecyclerView.ViewHolder{

        public ForecastViewHolder(View itemView) {
            super(itemView);
        }
    }
}


