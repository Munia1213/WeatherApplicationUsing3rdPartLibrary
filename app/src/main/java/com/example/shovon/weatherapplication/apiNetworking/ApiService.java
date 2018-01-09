package com.example.shovon.weatherapplication.apiNetworking;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.shovon.weatherapplication.apiNetworking.ApiEndPoint.BASE_URL;

/**
 * Created by SHOVON on 1/9/2018.
 */

public class ApiService {

    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
