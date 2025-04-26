package com.example.balancelifestyle;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class WishListViewModel extends AndroidViewModel {

    private static final String TAG = "WishListViewModel";

    private WishlistDatabase wishListDatabase;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<WishList>> wishLists = new MutableLiveData<>();

    public WishListViewModel(@NonNull Application application) {
        super(application);
        wishListDatabase = WishlistDatabase.getInstance(application);
    }

    public MutableLiveData<List<WishList>> getWishLists() {
        return wishLists;
    }

    public void refreshWishList() {
        Disposable disposable = wishListDatabase.wishListDao().getWishLists()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<WishList>>() {
                    @Override
                    public void accept(List<WishList> wishListsFromDb) throws Throwable {
                        wishLists.setValue(wishListsFromDb);
                    }
                });
        compositeDisposable.add(disposable);
    }

    public void remove(WishList wishList){
        Disposable disposable = wishListDatabase.wishListDao().remove(wishList.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Throwable {
                        Log.d(TAG, "Removed: "+ wishList.getId());
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
