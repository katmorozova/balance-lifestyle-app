package com.example.balancelifestyle;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.balancelifestyle.database.ToDoList;
import com.example.balancelifestyle.database.ToDoListDatabase;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ToDoViewModel extends AndroidViewModel {

    private ToDoListDatabase toDoListDatabase;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<ToDoList>> toDoLists = new MutableLiveData<>();

    public ToDoViewModel(@NonNull Application application) {
        super(application);
        toDoListDatabase = ToDoListDatabase.getInstance(application);
    }

    public LiveData<List<ToDoList>> getToDoLists() {
        return toDoLists;
    }

    public void refreshToDoList() {
        Disposable disposable = toDoListDatabase.toDoListDao().getToDoLists()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<ToDoList>>() {
                    @Override
                    public void accept(List<ToDoList> toDoListFromDb) throws Throwable {
                        toDoLists.setValue(toDoListFromDb);
                    }
                });
        compositeDisposable.add(disposable);
    }

    public void remove(ToDoList toDoList){
        Disposable disposable = toDoListDatabase.toDoListDao().remove(toDoList.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Throwable {
                        Log.d("ToDoViewModel", "Removed: "+ toDoList.getId());
                        refreshToDoList();
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
