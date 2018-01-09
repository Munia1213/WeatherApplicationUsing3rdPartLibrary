package com.example.shovon.weatherapplication.apiNetworking;

import com.example.shovon.weatherapplication.model.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by SHOVON on 1/9/2018.
 */

public interface ApiClient {

    //by city name
    @GET("data/2.5/forecast")
    Call <WeatherData> getDataByCity (@Query("q") String cityName,
                                     @Query("appid") String apiTokenKey);

    //by latitude & longitude
    @GET("data/2.5/forecast")
    Call <WeatherData> getDataByLatLon (@Query("lat") Float latitude,
                                       @Query("lon") Float longitude,
                                       @Query("appid") String apiTokenKey);

    //by celsius format
    @GET("data/2.5/forecast")
    Call <WeatherData> getDataByCelcius (@Query("q") String cityName,
                                     @Query("units") String celsiusFormat,
                                     @Query("appid") String apiTokenKey);


}
