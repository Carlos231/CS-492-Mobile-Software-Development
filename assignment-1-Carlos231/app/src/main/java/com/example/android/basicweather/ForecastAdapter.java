/* Carlos Lopez-Molina
 CS492 - Assignment 1
 */
package com.example.android.basicweather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.basicweather.R;

import java.util.ArrayList;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {
//    hold forecast list like in main
    private ArrayList<String> mForecastList;
    private OnForecastCheckedChangeListener mListener;

//  constructor
    public ForecastAdapter(OnForecastCheckedChangeListener listener){
//        intitialize the array
        mForecastList = new ArrayList<>();
//        initialize the additional info array for forecasts
//        toastInfo();
        mListener = listener;
    }

    public interface OnForecastCheckedChangeListener{
        void onForecastCheckedChanged(int position);
    }

//    onCreateViewHolder() – called when a new view holder is created
//    This method needs to allocate a new TodoViewHolder, inflate the forecast item layout into it, and return the new TodoViewHolder object
    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.forecast_list_item, parent,
                false);
        return new ForecastViewHolder(itemView);
    }

//    onBindViewHolder() – called when a view holder is bound to new data
//which takes a view holder object and a list item position and binds the data corresponding to that list item position into the view holder
//    displays most recent first
    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {
        String forecast = mForecastList.get(position);
        holder.bind(forecast);
    }

//    public function to add a new forecast into the adapter’s data structure
    public void addForecast(String forecast) {
//        add to top of list
//        mForecastList.add(0, forecast);
//        add to end of list
        mForecastList.add(forecast);
        notifyItemInserted(0); //place at top of list
    }

//    get number of forecast in adapter
    @Override
    public int getItemCount() {
        return mForecastList.size();
    }

//    view holder is a class that represents the individual elements of forecast list
    class ForecastViewHolder extends RecyclerView.ViewHolder{
//        reference to the view holder’s TextView
        private TextView mForecastTV;

//        constructor that grabs view holders textview using its ID
        public ForecastViewHolder(final View itemView) {
            super(itemView);
            mForecastTV = itemView.findViewById(R.id.tv_forecast_text);

            TextView textView = itemView.findViewById(R.id.tv_forecast_text);
            //add new Forecast
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    //to call the new method we wrote in our main activity, triggering a new toast
//                    pass the position of the adapter to listener
                    mListener.onForecastCheckedChanged(getAdapterPosition());
                }
            });
        }
//      bind new data to this view holder
        void bind(String newForecastText) {
            mForecastTV.setText(newForecastText);
        }
    }
}
