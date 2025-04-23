package com.example.balancelifestyle;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.balancelifestyle.database.ToDoList;
import com.example.balancelifestyle.database.ToDoListDao;
import com.example.balancelifestyle.database.ToDoListDatabase;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AddToDoViewModel extends AndroidViewModel {

    private ToDoListDao toDoListDao;
    private MutableLiveData<Boolean> shouldCloseScreen = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public AddToDoViewModel(@NonNull Application application) {
        super(application);
        toDoListDao = ToDoListDatabase.getInstance(application).toDoListDao();
    }

    public MutableLiveData<Boolean> getShouldCloseScreen() {
        return shouldCloseScreen;
    }

    public void saveToDoList(ToDoList toDoList){
        Disposable disposable = toDoListDao.add(toDoList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Throwable {
                        Log.d("AddToDoViewModel", "subscribe");
                        shouldCloseScreen.setValue(true);
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
