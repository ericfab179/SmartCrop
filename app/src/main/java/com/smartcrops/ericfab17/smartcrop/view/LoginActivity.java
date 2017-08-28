package com.smartcrops.ericfab17.smartcrop.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.smartcrops.ericfab17.smartcrop.R;
import com.smartcrops.ericfab17.smartcrop.databinding.ActivityLoginBinding;
import com.smartcrops.ericfab17.smartcrop.viewModel.LoginViewModel;



public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding loginActivityBinding;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDatabinding();
        //setSupportActionBar(loginActivityBinding.toolbar);

    }

    private void initDatabinding() {
        loginActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginViewModel = new LoginViewModel();
        loginActivityBinding.setLoginViewModel(loginViewModel);


    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

}
