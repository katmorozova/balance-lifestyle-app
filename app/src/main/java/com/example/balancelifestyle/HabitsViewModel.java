package com.example.balancelifestyle;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import java.util.List;

public class HabitsViewModel extends AndroidViewModel {

    private HabitDatabase habitDatabase;


    public HabitsViewModel(@NonNull Application application){
        super(application);
        habitDatabase = HabitDatabase.getInstance(application);
    }

    public LiveData<List<Habit>> getHabits() {
        return habitDatabase.habitsDao().getHabits();
    }

    public void remove(Habit habit){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                habitDatabase.habitsDao().remove(habit.getId());
            }
        });
        thread.start();
    }
}
