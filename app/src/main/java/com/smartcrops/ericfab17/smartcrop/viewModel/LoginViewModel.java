package com.smartcrops.ericfab17.smartcrop.viewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.smartcrops.ericfab17.smartcrop.view.UserActivity;

/**
 * Created by ericfab17 on 26/08/17.
 */

public class LoginViewModel extends BaseObservable {


    private FirebaseAuth firebaseAuth;



    public ObservableField<String> email =  new ObservableField<>();
    public ObservableField<String> password =  new ObservableField<>();



    public void onClickLogin(View view ){
        final Context context = view.getContext();
        String email = this.email.get();
        String password = this.password.get();

        if(!validateForm(email, password)){
            return;
        }

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText( context, "GOOD", Toast.LENGTH_SHORT).show();
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    String userUID = user.getUid();
                    Intent userIntent = new Intent(context, UserActivity.class);
                    userIntent.setData(Uri.parse(userUID));
                    context.startActivity(userIntent);
                }
                else{
                    Toast.makeText( context, "TRY AGAIN", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private static boolean validateForm( String email, String password) {
        boolean validFlag = true;

        if (TextUtils.isEmpty(email)) {

            validFlag = false;
        } else {

        }

        if (TextUtils.isEmpty(password)) {

            validFlag = false;
        } else {

        }

        return validFlag;
    }

}
