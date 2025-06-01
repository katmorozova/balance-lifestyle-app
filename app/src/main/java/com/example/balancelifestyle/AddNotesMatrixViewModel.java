package com.example.balancelifestyle;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.balancelifestyle.database.NotesMatrixDatabase;
import com.example.balancelifestyle.database.NotesMatrixList;
import com.example.balancelifestyle.database.NotesMatrixListDao;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AddNotesMatrixViewModel extends AndroidViewModel {

    private NotesMatrixListDao notesMatrixListDao;
    private MutableLiveData<Boolean> shouldCloseScreen = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public AddNotesMatrixViewModel(@NonNull Application application) {
        super(application);
        notesMatrixListDao = NotesMatrixDatabase.getInstance(application).notesMatrixListDao();
    }

    public MutableLiveData<Boolean> getShouldCloseScreen() {
        return shouldCloseScreen;
    }

    public void saveNoteMatrix(NotesMatrixList notesMatrixList){
        Disposable disposable = notesMatrixListDao.add(notesMatrixList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Throwable {
                        Log.d("AddNotesMatrixViewModel", "subscribe");
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
