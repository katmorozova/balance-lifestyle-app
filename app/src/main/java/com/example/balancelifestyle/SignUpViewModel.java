package com.example.balancelifestyle;

import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;

public class SignUpViewModel extends ViewModel {

    private FirebaseAuth auth;

    public SignUpViewModel(){
        auth = FirebaseAuth.getInstance();
    }
}
