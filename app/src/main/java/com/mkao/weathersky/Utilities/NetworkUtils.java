package com.mkao.weathersky.Utilities;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

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

public  static  URL buildurl(Double lon, Double lat){
    //implementation at future lesson
    return  null;
}
/**
 * This method returns the entire result from the HTTP response.
 *
 * @param url The URL to fetch the HTTP response from.
 * @return The contents of the HTTP response.
 * @throws IOException Related to network and stream reading
 */
public static String  getResponseFromHttpUrl(URL url) throws IOException{
    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
    try {
        InputStream in = urlConnection.getInputStream();
        Scanner scanner = new Scanner(in);
        scanner.useDelimiter("\\A");

        boolean hasInput =scanner.hasNext();
        if (hasInput){
            return scanner.next();
        }else {
            return null;
        }
    }finally {
        urlConnection.disconnect();
    }
    //This establishes the connection to the Http server to fetch the results otherwiae and returns the null
 }
}
