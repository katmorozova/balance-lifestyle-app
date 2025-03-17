package com.example.balancelifestyle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserViewModel extends ViewModel {

    private FirebaseAuth auth;
    private  MutableLiveData<FirebaseUser> user = new MutableLiveData<>();

    public UserViewModel(){
        auth = FirebaseAuth.getInstance();
    }

    public LiveData<FirebaseUser> getUser() {
        return user;
    }
}
