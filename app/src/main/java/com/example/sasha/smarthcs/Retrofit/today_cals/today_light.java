package com.example.sasha.smarthcs.Retrofit.today_cals;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class today_light {
    @SerializedName("day")
    private List<String> day;


    public List<String> getDay() {
        return day;
    }

    public void setDay(List<String> day) {
        this.day = day;
    }
}
