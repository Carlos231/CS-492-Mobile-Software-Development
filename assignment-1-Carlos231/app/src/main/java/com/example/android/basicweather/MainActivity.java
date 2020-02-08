/* Carlos Lopez-Molina
 CS492 - Assignment 1
 */
package com.example.android.basicweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ForecastAdapter.OnForecastCheckedChangeListener {
    //reference to recycerview
    private RecyclerView mForecastListRV;
//    reference to the adapter
    private ForecastAdapter mForecastAdapter;

    //add toast
    private Toast mToast;

    //declares array to hold the forecasts
    private ArrayList<String> mForecastList;
    //declare array for dummy
    private ArrayList<String> mForecastDetailedList;

    //main function called when app is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set toast to null
        mToast = null;

//      initiate the array for forecasts
        mForecastList = new ArrayList<>();

        //initiate the array holding values to toast
        toastInfo();

        //get reference to recyclerview
        mForecastListRV = findViewById(R.id.rv_forecast_list);

//        Code to initialize recyclerview
//          Grab reference Then, we can add a new LinearLayoutManager to make sure our list items are laid out in a list, and we can let the RecyclerView know that all of our items have the same size, which will allow it to perform some rendering optimization
        mForecastListRV.setLayoutManager(new LinearLayoutManager(this));
        mForecastListRV.setHasFixedSize(true);

//        create new adapter to add to recyclerview
        mForecastAdapter = new ForecastAdapter(this);
//        connect adapter to recycler view
        mForecastListRV.setAdapter(mForecastAdapter);

        //add dummy weather forecast
        mForecastAdapter.addForecast("Tue April 11 - Sunny - 85F");
        mForecastAdapter.addForecast("Wed April 12 - Sunny and Warm - 75F");
        mForecastAdapter.addForecast("Th  April 13 - Sunny and Warm - 78F");
        mForecastAdapter.addForecast("Fri April 14 - Sunny - 80F");
        mForecastAdapter.addForecast("Sat April 15 - Sunny - 82F");
        mForecastAdapter.addForecast("Sun April 16 - Sunny - 90F");
        mForecastAdapter.addForecast("Mon April 17 - Windy with chance of rain - 70F");
        mForecastAdapter.addForecast("Tue April 18 - Rainy - 58F");
        mForecastAdapter.addForecast("Wed April 19 - Rainy - 56F");
        mForecastAdapter.addForecast("Thu April 20 - Partly Cloudy - 64F");
        mForecastAdapter.addForecast("Fri April 21 - Sunny and Warm - 75F");
        mForecastAdapter.addForecast("Sat April 22 - Sunny and Warm - 80F");
        mForecastAdapter.addForecast("Sun April 23 - Sunny and Warm - 85F");
        mForecastAdapter.addForecast("Mon April 24 - Rainy - 67");
        mForecastAdapter.addForecast("Fri April 28 - Thunderstorm - 56");
        mForecastAdapter.addForecast("Tue April 25 - Cold and icy - 32F");
        mForecastAdapter.addForecast("Wed April 26 - Snow - 35F");
        mForecastAdapter.addForecast("Thu April 27 - Snow - 30F");
    }

    //    initiate and add detailed dummy info
    public void toastInfo(){
        //      initiate the array for the additional info for forecast list
        mForecastDetailedList = new ArrayList<>();

        //        additional info for dummy forecast data
        mForecastDetailedList.add("Heat wave moving through the afternoon with a high of 85F and low 69F");
        mForecastDetailedList.add("Cloudless and generally warm, with a high of 75F and a low of 57F.  Some high clouds late in the day.");
        mForecastDetailedList.add("Cloudless and generally warm, with a high of 78F and a low of 64F.");
        mForecastDetailedList.add("Cloudless and warm with high 80F and low 64F. Clear skies throughout the day.");
        mForecastDetailedList.add("Sunny with clear skies, with a high of 82F and a low of 62F");
        mForecastDetailedList.add("Dry heat warning, drink a lot of water with a high of 90F and low 70. Will feel like 100F.");
        mForecastDetailedList.add("High 70F with a low of 64F Expect a lot of wind from the South early in the morning. Avoid any old trees unless you want it to turn you into a pancake.");
        mForecastDetailedList.add("Expect rain showers until late in the evening, with a high of 58F and a low of 47F. Don't forget your umbrella to stay dry");
        mForecastDetailedList.add("Rain showers throughout the morning with high 56F and low 49F. Rain clear up in the evening.");
        mForecastDetailedList.add("Rain showers with chance of thunder with high 64F and low 58F.");
        mForecastDetailedList.add("Cloudless and generally warm, with a high of 75F and a low of 57F.  Some high clouds late in the day.");
        mForecastDetailedList.add("Cloudless and generally warm, with a high of 80F and a low of 61F.  Hgh clouds late in the day.");
        mForecastDetailedList.add("Expect a high of 85 with a low of 70 for a warm night.");
        mForecastDetailedList.add("Rainy with a high of 67F and low of 52F. Local flood warning, don't forget to wear your high water pants.");
        mForecastDetailedList.add("Lightning with high winds approaching from the North with a high of 56F and low of 49F. Stay in doors as much as possible. Find your thunder buddy.");
        mForecastDetailedList.add("Windy and black ice on roads with high of 32F and low of 28F. Chains required on all vehicles.");
        mForecastDetailedList.add("Expect about 5 inches of snow with a high of 35F and low of 30F. Stock up on water and canned food as roads will be slippery.");
        mForecastDetailedList.add("Expect downfall of 3 inches of snow in the morning with a high of 30F and low of 27F. Stay indoors as weather gets better.");

    }

    @Override
    public void onForecastCheckedChanged(int position){
        //cancel any existing Toast before displaying a new one each time the user clicks
        if(mToast != null) {
            mToast.cancel();
        }
        //set the text the the position in the array where the user is clicking to toast
        String forecastText = mForecastDetailedList.get(position);
        mToast = Toast.makeText(this, forecastText, Toast.LENGTH_LONG);
        mToast.show();
    }
}
