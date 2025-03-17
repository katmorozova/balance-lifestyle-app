package com.example.balancelifestyle;

import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;

public class UserViewModel extends ViewModel {

    private FirebaseAuth auth;

    public UserViewModel(){
        auth = FirebaseAuth.getInstance();
    }
}
