package com.mkao.weathersky.Utilities;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;

/**
 * the objective of the class is to handle the openweather json data
 */
public final class OpenWeatherJsonUtils {
    /**
     * This method parses JSON from a web response and returns an array of Strings
     * describing the weather over various days from the forecast.
     * <p/>
     * Later on, we'll be parsing the JSON into structured data within the
     * getFullWeatherDataFromJson function, leveraging the data we have stored in the JSON. For
     * now, we just convert the JSON into human-readable strings.
     *
     * @param forecastJsonStr JSON response from server
     * @return Array of Strings describing weather data
     * @throws JSONException If JSON data cannot be properly parsed
     */
    public static String[] getSimpleWeatherStringsFromJson(Context context, String forecastJsonStr)
            throws JSONException {
        /*weather data ,Each day forecast into an array of elements
         */
        final String OWN_LIST = "list";
        /*All temperatures are children of the temperature object

         */
        final String OWN_TEMPARATURE = "temperature";
        /*Max temparature for the day*

         */
        final String OWN_MAX = "max";
        final String OWN_MIN = "min";

        final String OWN_WEATHER = "weather";
        final String OWN_DESCRIPTION = "main";
        final String OWN_MESSAGE = "cod";

        /*String array to hold each days weather string

         */
        String[] parssedWeatherInfo = null;
        JSONObject forecastJson = new JSONObject(forecastJsonStr);

        //if an error happens
        if (forecastJson.has(OWN_MESSAGE)) {
            int erroeCode = forecastJson.getInt(OWN_MESSAGE);
            switch (erroeCode) {
                case HttpURLConnection
                        .HTTP_OK:
                    break;
                case HttpURLConnection.HTTP_NOT_FOUND:
                    //where location is Invalid
                    return null;
                default:
                    /*server probably down*/
                    return null;
            }
        }
        JSONArray weatherArray = forecastJson.getJSONArray(OWN_LIST);

        return null;
    }
}

