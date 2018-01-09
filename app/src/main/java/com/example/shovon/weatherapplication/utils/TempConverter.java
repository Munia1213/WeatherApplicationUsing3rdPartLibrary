package com.example.shovon.weatherapplication.utils;

/**
 * Created by McGyver on 1/10/2018.
 */

public class TempConverter {

    public static double KenvinToCelcius(double kelvinTemp){

        double celciusTemp = (kelvinTemp -273.15);

        return celciusTemp;

    }
}
