package com.smartcrops.ericfab17.smartcrop.viewModel;

import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smartcrops.ericfab17.smartcrop.model.AutomaticIrrigationTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by ericfab17 on 21/09/17.
 */

public class AutomaticIrrigationViewModel extends Observable {

    private List<AutomaticIrrigationTask> automaticIrrigationTasksList;

    public AutomaticIrrigationViewModel() {
        this.automaticIrrigationTasksList = new ArrayList<>();
        addListener(automaticIrrigationTasksList);
    }

    public void onClickB(View view){
/*        AutomaticIrrigationTask automaticIrrigationTask = new AutomaticIrrigationTask("asdasd","kpoi","asdqwe");
        this.automaticIrrigationTasksList.add(automaticIrrigationTask);
        this.automaticIrrigationTasksList.add(automaticIrrigationTask);
        setChanged();
        notifyObservers();*/
        DatabaseReference stationsDatabaseReference = FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        //user.getIdToken();
        stationsDatabaseReference.child(user.getUid()).child("stationsList").child("station1").setValue("yeahperri");


    }


    public List<AutomaticIrrigationTask> getAutomaticIrrigationTasksList(){
        return automaticIrrigationTasksList;
    }

    private void addListener(final List<AutomaticIrrigationTask> automaticIrrigationTasksList1) {
        ValueEventListener automaticStationListListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String stationValueStr = (String) dataSnapshot.getValue();
                AutomaticIrrigationTask automaticIrrigationTask = new AutomaticIrrigationTask(stationValueStr,stationValueStr,stationValueStr);
                automaticIrrigationTasksList1.add(automaticIrrigationTask);
                automaticIrrigationTasksList1.add(automaticIrrigationTask);
                automaticIrrigationTasksList1.add(automaticIrrigationTask);
                automaticIrrigationTasksList1.add(automaticIrrigationTask);
                automaticIrrigationTasksList1.add(automaticIrrigationTask);
                setChanged();
                notifyObservers();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference stationsDatabaseReference = FirebaseDatabase.getInstance().getReference();
        stationsDatabaseReference.child(user.getUid()).child("stationsList").child("station1").addListenerForSingleValueEvent(automaticStationListListener);
    }


}
