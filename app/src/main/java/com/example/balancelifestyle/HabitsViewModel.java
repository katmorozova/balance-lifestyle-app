package com.example.balancelifestyle;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HabitsViewModel extends AndroidViewModel {

    private HabitDatabase habitDatabase;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<Habit>> habits = new MutableLiveData<>();


    public HabitsViewModel(@NonNull Application application){
        super(application);
        habitDatabase = HabitDatabase.getInstance(application);
    }

    public LiveData<List<Habit>> getHabits() {
        return habits;
    }

    public void refreshList() {
        Disposable disposable = habitDatabase.habitsDao().getHabits()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Habit>>() {
                    @Override
                    public void accept(List<Habit> habitsFromDb) throws Throwable {
                        habits.setValue(habitsFromDb);
                    }
                });
        compositeDisposable.add(disposable);
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
