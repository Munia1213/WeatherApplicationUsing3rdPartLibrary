package com.example.shovon.weatherapplication.apiNetworking;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SHOVON on 1/9/2018.
 */

public class ApiService {

    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    Retrofit.Builder builder =
            new Retrofit.Builder()
            .baseUrl(ApiEndPoint.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit =
            builder
            .client(httpClient.build())
            .build();

ApiClient client = retrofit.create(ApiClient.class);
}
