package com.example.balancelifestyle;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HabitsViewModel extends AndroidViewModel {

    private HabitDatabase habitDatabase;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();



    public HabitsViewModel(@NonNull Application application){
        super(application);
        habitDatabase = HabitDatabase.getInstance(application);
    }

    public LiveData<List<Habit>> getHabits() {
        return habitDatabase.habitsDao().getHabits();
    }

    public void remove(Habit habit){
        Disposable disposable = habitDatabase.habitsDao().remove(habit.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Throwable {
                        Log.d("HabitsViewModel", "Removed: "+ habit.getId());
                    }
                });
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }

}
