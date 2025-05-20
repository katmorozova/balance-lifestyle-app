package com.example.balancelifestyle;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.balancelifestyle.database.NoteMatrix;
import com.example.balancelifestyle.database.NoteMatrixDatabase;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UrgentImportantViewModel extends AndroidViewModel {

    private static final String TAG = "UrgentImportantViewModel";

    private NoteMatrixDatabase noteMatrixDatabase;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<NoteMatrix>> noteMatrixList = new MutableLiveData<>();


    public UrgentImportantViewModel(@NonNull Application application){
        super(application);
        noteMatrixDatabase = NoteMatrixDatabase.getInstance(application);
    }

    public MutableLiveData<List<NoteMatrix>> getNoteMatrixList() {
        return noteMatrixList;
    }

    public void refreshWishList() {
        Disposable disposable = noteMatrixDatabase.noteMatrixDao().getNoteMatrixs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<NoteMatrix>>() {
                    @Override
                    public void accept(List<NoteMatrix> noteMatrices) throws Throwable {
                        noteMatrixList.setValue(noteMatrices);
                    }
                });
        compositeDisposable.add(disposable);

    }

    public void remove(NoteMatrix noteMatrix){
        Disposable disposable = noteMatrixDatabase.noteMatrixDao().remove(
                noteMatrix.getId(), noteMatrix.getCategory()
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Throwable {
                        Log.d(TAG, "Removed: "+ noteMatrix.getId());
                        refreshWishList();
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
