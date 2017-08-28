package com.smartcrops.ericfab17.smartcrop.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by ericfab17 on 26/08/17.
 */

public class LoginViewModel extends BaseObservable {


    private FirebaseAuth firebaseAuth;



    public void onClickLogin(View view, String email, String password ){
        Context context = view.getContext();
        //Toast.makeText( context, email+password,Toast.LENGTH_SHORT).show();

/*        firebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    context.startActivity(MainActivity.);
                }
            }
        });*/


    }

}
