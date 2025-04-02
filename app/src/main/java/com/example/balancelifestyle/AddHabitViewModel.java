package com.example.balancelifestyle;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class AddHabitViewModel extends AndroidViewModel {

    private HabitsDao habitsDao;
    private MutableLiveData<Boolean> shouldCloseScreen = new MutableLiveData<>();

    public AddHabitViewModel(@NonNull Application application) {
        super(application);
        habitsDao = HabitDatabase.getInstance(application).habitsDao();
    }

    public LiveData<Boolean> getShouldCloseScreen() {
        return shouldCloseScreen;
    }

    public void saveHabit(Habit habit){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                habitsDao.add(habit);
                shouldCloseScreen.postValue(true);
            }
        });
        thread.start();
    }
}
