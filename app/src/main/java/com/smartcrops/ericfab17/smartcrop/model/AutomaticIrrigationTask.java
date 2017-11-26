package com.smartcrops.ericfab17.smartcrop.model;

import java.io.Serializable;

/**
 * Created by ericfab17 on 21/09/17.
 */

public class AutomaticIrrigationTask implements Serializable{
    public String date;
    public String initTime;
    public String water;

    public AutomaticIrrigationTask(String date, String initTime, String water) {
        this.date = date;
        this.initTime = initTime;
        this.water = water;
    }
}
