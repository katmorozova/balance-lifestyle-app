package com.example.balancelifestyle;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.balancelifestyle.database.NoteList;
import com.example.balancelifestyle.database.NoteListDatabase;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class WishListViewModel extends AndroidViewModel {

    private static final String TAG = "WishListViewModel";

    private NoteListDatabase noteListDatabase;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<NoteList>> noteLists = new MutableLiveData<>();

    public WishListViewModel(@NonNull Application application) {
        super(application);
        noteListDatabase = NoteListDatabase.getInstance(application);
    }

    public MutableLiveData<List<NoteList>> getNoteLists() {
        return noteLists;
    }

    public void refreshWishList() {
        Disposable disposable = noteListDatabase.noteListDao().getNoteLists()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<NoteList>>() {
                    @Override
                    public void accept(List<NoteList> noteListsFromDb) throws Throwable {
                        noteLists.setValue(noteListsFromDb);
                    }
                });
        compositeDisposable.add(disposable);
    }

    public void remove(NoteList noteList){
        Disposable disposable = noteListDatabase.noteListDao().remove(noteList.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Throwable {
                        Log.d(TAG, "Removed: "+ noteList.getId());
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
