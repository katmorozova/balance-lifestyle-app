package com.example.balancelifestyle;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnFailureListener;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpViewModel extends ViewModel {

    private FirebaseAuth auth;

    private MutableLiveData<String> error = new MutableLiveData<>();
    private  MutableLiveData<FirebaseUser> user = new MutableLiveData<>();

    public SignUpViewModel(){
        auth = FirebaseAuth.getInstance();
        auth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() != null){
                    user.setValue(firebaseAuth.getCurrentUser());
                }
            }
        });
    }

    public LiveData<String> getError() {
        return error;
    }

    public LiveData<FirebaseUser> getUser() {
        return user;
    }

    public void signUpUser(
            String name,
            String lastName,
            int age,
            String email,
            String password
    ){
        auth.createUserWithEmailAndPassword(email, password)
                .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                error.setValue(e.getMessage());
            }
        });
    }

    public void saveUserData(Context context, String name, String lastName, int age){
        SharedPreferences preferences = context.getSharedPreferences(
                "UserPrefs",
                Context.MODE_PRIVATE
        );
        SharedPreferences.Editor userData = preferences.edit();
        userData.putString("name", name);
        userData.putString("lastName", lastName);
        userData.putInt("age", age);
        userData.apply();
    }
}
