package com.smartcrops.ericfab17.smartcrop.viewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.smartcrops.ericfab17.smartcrop.view.AutomaticIrrigationActivity;

/**
 * Created by ericfab17 on 20/09/17.
 */

public class UserViewModel extends BaseObservable {

    public String userName;
    private FirebaseUser user;

    public UserViewModel(){
        this.user  = FirebaseAuth.getInstance().getCurrentUser();
        this.userName = user.getEmail();
    }

    public void onClickAutomaticIrrigation(View view){
        final Context context = view.getContext();
        Intent automaticIrrigationIntent = new Intent(context, AutomaticIrrigationActivity.class);
        context.startActivity(automaticIrrigationIntent);
    }
}
