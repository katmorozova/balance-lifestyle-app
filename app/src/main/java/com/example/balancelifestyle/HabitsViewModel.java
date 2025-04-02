package com.example.balancelifestyle;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class HabitsViewModel extends AndroidViewModel {

    private HabitDatabase habitDatabase;

    public HabitsViewModel(@NonNull Application application){
        super(application);
        habitDatabase = HabitDatabase.getInstance(application);
    }

    public void remove(Habit habit){

    }
}
