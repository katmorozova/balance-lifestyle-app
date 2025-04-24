package com.example.balancelifestyle;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserViewModel extends ViewModel {

    private static final String TAG = "UserViewModel";

    private final FirebaseAuth auth;


    private final MutableLiveData<FirebaseUser> user = new MutableLiveData<>();

    public UserViewModel(){
        auth = FirebaseAuth.getInstance();
        auth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    user.setValue(firebaseAuth.getCurrentUser());

            }
        });
    }

    public LiveData<FirebaseUser> getUser() {
        return user;
    }

    public void logOut(){
        auth.signOut();
    }

    public void deleteUserData(Context context){
        SharedPreferences preferences = context.getSharedPreferences(
                "UserPrefs",
                Context.MODE_PRIVATE
        );
        SharedPreferences.Editor userData = preferences.edit();
        userData.clear();
        userData.apply();
    }

    public void deleteUserProfile(Context context, String email, String password){
        final FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        // Verifica si hay un usuario autenticado antes de continuar
        if (currentUser == null) {
            Log.e(TAG, "No user is currently logged in.");
            return;
        }

        // Verifica que el correo y la contraseña no estén vacíos
        if (email.isEmpty() || password.isEmpty()) {
            Log.e(TAG, "Email or password cannot be empty.");
            return;
        }

        AuthCredential credential = EmailAuthProvider.getCredential(email, password);

        currentUser.reauthenticate(credential)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Reauthentication successful");

                            currentUser.delete()
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> deleteTask) {
                                            if (deleteTask.isSuccessful()) {
                                                Log.d(TAG, "User account deleted from Firebase");
                                                deleteUserData(context);
                                            } else {
                                                Log.e(TAG, "Error deleting user", deleteTask.getException());
                                            }
                                        }
                                    });

                        } else {
                            Log.e(TAG, "Error in reauthentication", task.getException());
                        }
                    }
                });
    }


}
