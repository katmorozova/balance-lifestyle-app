package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WishListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewWishlist;
    private FloatingActionButton fabAddNote;

    private WishListAdapter wishListAdapter;

    private WishListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wish_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        viewModel = new ViewModelProvider(this).get(WishListViewModel.class);
        wishListAdapter = new WishListAdapter();
        recyclerViewWishlist.setAdapter(wishListAdapter);
        setUpClickListeners();
    }

    public void initViews(){
        recyclerViewWishlist = findViewById(R.id.recyclerViewWishlist);
        fabAddNote = findViewById(R.id.fabAddNote);
    }

    public static Intent newIntent(Context context){
        return new Intent(context, WishListActivity.class);
    }

    private void setUpClickListeners(){
        fabAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = AddWishListActivity.newIntent(WishListActivity.this);
                startActivity(intent);
                finish();
            }
        });
    }

}