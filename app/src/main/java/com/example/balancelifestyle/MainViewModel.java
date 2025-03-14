package com.example.balancelifestyle;

import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;

public class MainViewModel extends ViewModel {

    private FirebaseAuth auth;

    public MainViewModel(){
        auth = FirebaseAuth.getInstance();
    }
}
