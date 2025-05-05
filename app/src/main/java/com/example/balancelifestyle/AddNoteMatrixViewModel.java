package com.example.balancelifestyle;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.balancelifestyle.database.NoteMatrix;
import com.example.balancelifestyle.database.NoteMatrixDao;
import com.example.balancelifestyle.database.NoteMatrixDatabase;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AddNoteMatrixViewModel extends AndroidViewModel {

    private static final String TAG = "AddNoteMatrixViewModel";

    private NoteMatrixDao noteMatrixDao;
    private MutableLiveData<Boolean> shouldCloseScreen = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public AddNoteMatrixViewModel(@NonNull Application application) {
        super(application);
        noteMatrixDao = NoteMatrixDatabase.getInstance(application).noteMatrixDao();
    }

    public MutableLiveData<Boolean> getShouldCloseScreen() {
        return shouldCloseScreen;
    }


    public void saveNoteMatrix(NoteMatrix noteMatrix){
        Disposable disposable = noteMatrixDao.add(noteMatrix)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Throwable {
                        Log.d(TAG, "subscribe");
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
