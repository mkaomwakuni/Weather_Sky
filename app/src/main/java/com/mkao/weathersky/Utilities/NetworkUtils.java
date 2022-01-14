package com.mkao.weathersky.Utilities;

import android.net.Uri;
import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

public final class NetworkUtils {

    private static  final  String TAG = NetworkUtils.class.getSimpleName();
    private static final String DYNAMIC_WEATHER_URL = "https://andfun-weather.udacity.com/weather";
    private  static final  String STATIC_WEATHER_URL =     "https://andfun-weather.udacity.com/staticweather";
    private  static final  String FORECAST_BASE_URL = STATIC_WEATHER_URL;

    /* API Return Format */
    private  static final String format = "json";
    private static final String units = "metric";

    private static  final int returndays= 14;
    //the number of the days that the api will retrieve from the api to our app

    final static String QUERY_PARAM = "q";
    final static String LAT_PARAM = "lat";
    final static  String LONG_PARAM = "lon";
    final static  String DAYS_PARAM = "cnt";
    final static String FORMAT_PARAM = "mode";
    final static  String UNITS_PARAM = "units";

public static URL buildurl(String locationQuery){
    Uri builtUri = Uri.parse(FORECAST_BASE_URL).buildUpon()
            .appendQueryParameter(QUERY_PARAM,locationQuery)
            .appendQueryParameter(FORMAT_PARAM,format)
            .appendQueryParameter(UNITS_PARAM,units)
            .appendQueryParameter(DAYS_PARAM,Integer.toString(returndays))
            .build();

    URL url = null;

    try {
        url = new URL(builtUri.toString());
    }catch (MalformedURLException e){
        e.printStackTrace();
    }
    Log.v(TAG,"Built URI" + url);
    return  url;
}
}
