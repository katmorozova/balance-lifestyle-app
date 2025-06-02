package com.example.balancelifestyle;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.balancelifestyle.database.NotesMatrixDatabase;
import com.example.balancelifestyle.database.NotesMatrixList;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class GoalsViewModel extends AndroidViewModel {

    private static final String TAG = "GoalsViewModel";

    private NotesMatrixDatabase notesMatrixDatabase;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<NotesMatrixList>> notesMatrixLists = new MutableLiveData<>();


    public GoalsViewModel(@NonNull Application application) {
        super(application);
        notesMatrixDatabase = NotesMatrixDatabase.getInstance(application);
    }

    public LiveData<List<NotesMatrixList>> getNotesMatrixLists(int typeOfMatrixList) {
        return notesMatrixLists;
    }


    public void refreshNotesMatrixList(int typeOfMatrixList) { //dependiendo de categoria(typeOfMatrixList), radiobutton elegido renovar datos de la db
        Disposable disposable = notesMatrixDatabase.notesMatrixListDao()
                .getNotesMatrixLists(typeOfMatrixList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<List<NotesMatrixList>>() {
                        @Override
                        public void accept(List<NotesMatrixList> notesMatrixListsFromDb) throws Throwable {
                            notesMatrixLists.setValue(notesMatrixListsFromDb);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Throwable {
                            Log.e(TAG, "Error cargando datos", throwable);
                        }
                    });
        compositeDisposable.add(disposable);
    }

    public void remove(NotesMatrixList notesMatrixList){
        Disposable disposable = notesMatrixDatabase.notesMatrixListDao()
                .remove(notesMatrixList.getId(), notesMatrixList.getTypeOfMatrixList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Throwable {
                        Log.d(
                                TAG,
                                "Removed: "+notesMatrixList.getId()
                                        + notesMatrixList.getTypeOfMatrixList()
                        );
                        refreshNotesMatrixList(notesMatrixList.getTypeOfMatrixList());
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
