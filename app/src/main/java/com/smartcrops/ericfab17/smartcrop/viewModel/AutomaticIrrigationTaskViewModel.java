package com.smartcrops.ericfab17.smartcrop.viewModel;

import android.databinding.BaseObservable;

import com.smartcrops.ericfab17.smartcrop.model.AutomaticIrrigationTask;

/**
 * Created by ericfab17 on 21/09/17.
 */

public class AutomaticIrrigationTaskViewModel extends BaseObservable {
    private AutomaticIrrigationTask automaticIrrigationTask;

    public AutomaticIrrigationTaskViewModel(AutomaticIrrigationTask automaticIrrigationTask){
        this.automaticIrrigationTask = automaticIrrigationTask;
    }

    public String getDate(){
        return automaticIrrigationTask.date;
    }

    public String getInitTime(){
        return automaticIrrigationTask.initTime;
    }

    public String getWater(){
        return automaticIrrigationTask.water;
    }

    public void setAutomaticIrrigationTask(AutomaticIrrigationTask automaticIrrigationTask){
        this.automaticIrrigationTask = automaticIrrigationTask;
        notifyChange();
    }
}
