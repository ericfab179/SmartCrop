package com.smartcrops.ericfab17.smartcrop.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.smartcrops.ericfab17.smartcrop.R;
import com.smartcrops.ericfab17.smartcrop.databinding.UserActivityBinding;
import com.smartcrops.ericfab17.smartcrop.viewModel.UserViewModel;

public class UserActivity extends AppCompatActivity {

    private UserActivityBinding userActivityBinding;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseAuth.getInstance().getCurrentUser().getUid();
        super.onCreate(savedInstanceState);
        initDatabinding();
    }

    private void initDatabinding() {
        userActivityBinding = DataBindingUtil.setContentView(this, R.layout.user_activity);
        userViewModel = new UserViewModel();
        userActivityBinding.setUserViewModel(userViewModel);

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
