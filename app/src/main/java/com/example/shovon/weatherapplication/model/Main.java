package com.example.shovon.weatherapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by McGyver on 1/9/2018.
 */

public class Main {
    @SerializedName("temp")
    @Expose
    private String temp;
    @SerializedName("temp_min")
    @Expose
    private String tempMin;
    @SerializedName("temp_max")
    @Expose
    private String tempMax;
    @SerializedName("pressure")
    @Expose
    private String pressure;
    @SerializedName("sea_level")
    @Expose
    private Float seaLevel;
    @SerializedName("grnd_level")
    @Expose
    private Float grndLevel;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;
    @SerializedName("temp_kf")
    @Expose
    private Float tempKf;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public Float getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(Float seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Float getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(Float grndLevel) {
        this.grndLevel = grndLevel;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Float getTempKf() {
        return tempKf;
    }

    public void setTempKf(Float tempKf) {
        this.tempKf = tempKf;
    }
}
