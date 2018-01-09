package com.example.shovon.weatherapplication;

import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shovon.weatherapplication.apiNetworking.ApiClient;
import com.example.shovon.weatherapplication.apiNetworking.ApiService;
import com.example.shovon.weatherapplication.model.WeatherData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button clickBtn;
    ApiClient apiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiClient = ApiService.getClient().create(ApiClient.class);

        clickBtn = findViewById(R.id.clickBtn);
        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialogFragment bottomSheetDialogFragment = new CustomBottomSheetDialogFragment();
                bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
            }
        });

        getWeatherByCity();
    }

    private void getWeatherByCity() {

        Call<WeatherData> call = apiClient.getDataByCity("dhaka,bd","e842bad857fc2320feebce44eca57e2f");
        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {

                if (response.isSuccessful()){
                    Log.w("data",""+response.body().getCity().getCountry().toString());
                    Toast.makeText(MainActivity.this,""+response.body().getCity().getCountry(),Toast.LENGTH_SHORT).show();
                }else {

                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                Toast.makeText(MainActivity.this,"please try again",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
