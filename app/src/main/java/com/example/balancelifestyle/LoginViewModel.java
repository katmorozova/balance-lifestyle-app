package com.example.balancelifestyle;

import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;

public class LoginViewModel extends ViewModel {

    private FirebaseAuth auth;

    public LoginViewModel(){
        auth = FirebaseAuth.getInstance();
    }
}
