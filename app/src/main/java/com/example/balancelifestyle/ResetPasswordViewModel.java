package com.example.balancelifestyle;

import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordViewModel extends ViewModel {

    private FirebaseAuth auth = FirebaseAuth.getInstance();

    public ResetPasswordViewModel(){
    }

    public void resetUserPassword(String email){

    }
}
