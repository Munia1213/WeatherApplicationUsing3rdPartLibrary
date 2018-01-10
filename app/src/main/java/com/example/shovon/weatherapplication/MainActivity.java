package com.example.shovon.weatherapplication;

import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shovon.weatherapplication.apiNetworking.ApiClient;
import com.example.shovon.weatherapplication.apiNetworking.ApiEndPoint;
import com.example.shovon.weatherapplication.apiNetworking.ApiService;
import com.example.shovon.weatherapplication.model.WeatherData;
import com.example.shovon.weatherapplication.utils.TempConverter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.shovon.weatherapplication.apiNetworking.ApiEndPoint.API_KEY;

public class MainActivity extends AppCompatActivity {
    RelativeLayout clickBtn;
    ApiClient apiClient;

    TextView cityTV;
    TextView tempTV;
    TextView tempMinValueTV;

    TextView tempMinTV;
    TextView maxTempValueTV;
    TextView pressureValueTV;
    TextView humidityValueTV;

    Button locationChangeBtn;
    Button weatherFormatBtn;

    RelativeLayout todayRL;
    RelativeLayout tomorrowRL;
    RelativeLayout thirdDayRL;
    RelativeLayout fourthDayRL;
    RelativeLayout fifthDayRL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiClient = ApiService.getClient().create(ApiClient.class);

        cityTV = findViewById(R.id.cityTV);
        tempTV = findViewById(R.id.tempTV);

        tempMinTV = findViewById(R.id.tempMinTV);
        tempMinValueTV = findViewById(R.id.tempMinValueTV);
        maxTempValueTV = findViewById(R.id.maxTempValueTV);
        pressureValueTV = findViewById(R.id.pressureValueTV);
        humidityValueTV = findViewById(R.id.humidityValueTV);

        locationChangeBtn = findViewById(R.id.locationChangeBtn);
        locationChangeBtn.setOnClickListener(myOnClickListener);

        weatherFormatBtn = findViewById(R.id.weatherFormatBtn);
        weatherFormatBtn.setOnClickListener(myOnClickListener);

        todayRL = findViewById(R.id.todayRL);
        todayRL.setOnClickListener(myOnClickListener);

        tomorrowRL = findViewById(R.id.tomorrowRL);
        tomorrowRL.setOnClickListener(myOnClickListener);

        thirdDayRL = findViewById(R.id.thirdDayRL);
        thirdDayRL.setOnClickListener(myOnClickListener);

        fourthDayRL = findViewById(R.id.fourthDayRL);
        fourthDayRL.setOnClickListener(myOnClickListener);

        fifthDayRL = findViewById(R.id.fifthDayRL);
        fifthDayRL.setOnClickListener(myOnClickListener);


//        clickBtn = findViewById(R.id.clickBtn);
//        clickBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                BottomSheetDialogFragment bottomSheetDialogFragment = new CustomBottomSheetDialogFragment();
//                bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
//            }
//        });

        getWeatherByCity();
    }



    View.OnClickListener myOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){

                case R.id.locationChangeBtn:
                    Toast.makeText(MainActivity.this,"change your location",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.weatherFormatBtn:
                    Toast.makeText(MainActivity.this,"change weather format",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.todayRL:
                    BottomSheetDialogFragment bottomSheetDialogFragment = new CustomBottomSheetDialogFragment();
                    bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
                    break;

                case R.id.tomorrowRL:
                    BottomSheetDialogFragment bottomSheetDialogFragment_tmrw = new CustomBottomSheetDialogFragment();
                    bottomSheetDialogFragment_tmrw.show(getSupportFragmentManager(), bottomSheetDialogFragment_tmrw.getTag());
                    break;

                case R.id.thirdDayRL:
                    BottomSheetDialogFragment bottomSheetDialogFragment_third = new CustomBottomSheetDialogFragment();
                    bottomSheetDialogFragment_third.show(getSupportFragmentManager(), bottomSheetDialogFragment_third.getTag());
                    break;

                case R.id.fourthDayRL:
                    BottomSheetDialogFragment bottomSheetDialogFragment_fourth = new CustomBottomSheetDialogFragment();
                    bottomSheetDialogFragment_fourth.show(getSupportFragmentManager(), bottomSheetDialogFragment_fourth.getTag());
                    break;

                case R.id.fifthDayRL:
                    BottomSheetDialogFragment bottomSheetDialogFragment_fifth = new CustomBottomSheetDialogFragment();
                    bottomSheetDialogFragment_fifth.show(getSupportFragmentManager(), bottomSheetDialogFragment_fifth.getTag());
                    break;

            }
        }
    };




    private void getWeatherByCity() {

        Call<WeatherData> call = apiClient.getDataByCelcius("dhaka,bd","metric", API_KEY);
        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {

                if (response.isSuccessful()){
                    Log.w("data",""+response.body().getCity().getCountry().toString());
                    Toast.makeText(MainActivity.this,""+response.body().getCity().getCountry(),Toast.LENGTH_SHORT).show();

                    cityTV.setText(response.body().getCity().getName().toString());

//                   double celcTemp = TempConverter.KenvinToCelcius(response.body().getList().get(0).getMain().getTemp());
//                    tempTV.setText((int) celcTemp + "°"+"C");
                    tempTV.setText(response.body().getList().get(0).getMain().getTemp().toString());
                    tempMinValueTV.setText(response.body().getList().get(0).getMain().getTempMin().toString());
                    maxTempValueTV.setText(response.body().getList().get(0).getMain().getTempMax().toString());
                    pressureValueTV.setText(response.body().getList().get(0).getMain().getPressure().toString());
                    humidityValueTV.setText(response.body().getList().get(0).getMain().getHumidity().toString());

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
