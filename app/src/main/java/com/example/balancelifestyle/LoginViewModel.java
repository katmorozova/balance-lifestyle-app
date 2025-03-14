package com.example.balancelifestyle;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginViewModel extends ViewModel {

    private FirebaseAuth auth;

    private static final MutableLiveData<String> error = new MutableLiveData<>();
    private static final MutableLiveData<FirebaseUser> user = new MutableLiveData<>();

    public LoginViewModel(){
        auth = FirebaseAuth.getInstance();
    }

    public static LiveData<String> getError() {
        return error;
    }

    public static LiveData<FirebaseUser> getUser() {
        return user;
    }

    public void login(String email, String password){
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(
                new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                error.setValue(e.getMessage());
            }
        });
    }
}
