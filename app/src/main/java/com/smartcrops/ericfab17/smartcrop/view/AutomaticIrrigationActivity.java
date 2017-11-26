package com.smartcrops.ericfab17.smartcrop.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.smartcrops.ericfab17.smartcrop.R;
import com.smartcrops.ericfab17.smartcrop.databinding.AutomaticIrrigationActivityBinding;
import com.smartcrops.ericfab17.smartcrop.viewModel.AutomaticIrrigationViewModel;

import java.util.Observable;
import java.util.Observer;

public class AutomaticIrrigationActivity extends AppCompatActivity implements Observer{

    private AutomaticIrrigationActivityBinding automaticIrrigationActivityBinding;
    private AutomaticIrrigationViewModel automaticIrrigationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setupAutomaticIrrigationTasksRView(automaticIrrigationActivityBinding.automaticIrrigationTasksRecyclerView);
        setupObserver(automaticIrrigationViewModel);
    }


    private void initDataBinding(){
        automaticIrrigationActivityBinding = DataBindingUtil.setContentView(this, R.layout.automatic_irrigation_activity);
        automaticIrrigationViewModel = new AutomaticIrrigationViewModel();
        automaticIrrigationActivityBinding.setAutomaticIrrigationViewModel(automaticIrrigationViewModel);
    }

    private void setupAutomaticIrrigationTasksRView(RecyclerView automaticIrrigationTasksRecyclerView) {
        AutomaticIrrigationTaskAdapter adapter = new AutomaticIrrigationTaskAdapter();
        automaticIrrigationTasksRecyclerView.setAdapter(adapter);
        automaticIrrigationTasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof AutomaticIrrigationViewModel){
            AutomaticIrrigationTaskAdapter adapter = (AutomaticIrrigationTaskAdapter) automaticIrrigationActivityBinding.automaticIrrigationTasksRecyclerView.getAdapter();
            AutomaticIrrigationViewModel automaticIrrigationViewModel = (AutomaticIrrigationViewModel) observable;
            adapter.setAutomaticIrrigationTaskList(automaticIrrigationViewModel.getAutomaticIrrigationTasksList());
        }

    }
}
