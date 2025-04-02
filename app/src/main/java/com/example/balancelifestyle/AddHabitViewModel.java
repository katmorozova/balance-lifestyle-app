package com.example.balancelifestyle;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class AddHabitViewModel extends AndroidViewModel {

    private HabitsDao habitsDao;

    public AddHabitViewModel(@NonNull Application application) {
        super(application);
        habitsDao = HabitDatabase.getInstance(application).habitsDao();
    }

    public void saveHabit(Habit habit){

    }
}
