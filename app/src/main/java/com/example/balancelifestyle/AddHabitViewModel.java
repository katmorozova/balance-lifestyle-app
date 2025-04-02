package com.example.balancelifestyle;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;

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
        habitsDao.add(habit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
            @Override
            public void run() throws Throwable {
                shouldCloseScreen.setValue(true);
            }
        });

    }
}
