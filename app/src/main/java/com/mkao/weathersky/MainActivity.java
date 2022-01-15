package com.mkao.weathersky;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.mkao.weathersky.Utilities.NetworkUtils;
import com.mkao.weathersky.Utilities.OpenWeatherJsonUtils;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   // Create a Textview field to hold the weather display TextView//
    private TextView weather_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weather_data = (TextView) findViewById(R.id.weather_data);

    }
    //Create a class that extends AsyncTask to perform network requests
    public class Retrivedata extends AsyncTask<String,Void,String[]>{
        @Override
        protected String[] doInBackground (String... params){

          /*  If there data, there's nothing to look up. */
            if (params.length==0){
                return  null;
            }

            String Locality = params[0];
            URL WeatherRequestUrl = NetworkUtils.buildurl(Locality);
            try {
                String jsonWeatherResponse = NetworkUtils.getResponseFromHttpUrl(WeatherRequestUrl);

                String[] simpleJsonWeatherData = OpenWeatherJsonUtils.getSimpleWeatherStringsFromJson(MainActivity.this, jsonWeatherResponse);
                return  simpleJsonWeatherData;
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }

        }
        //To display the results of the network request onPostExecute has to be Overridden
        @Override
        protected void onPostExecute(String[] weatherData){
            if (weatherData !=null){

                for (String weatherString : weatherData ){
                    weather_data.append(weatherString + "\n\n\n");
                }
            }
        }

    }
}