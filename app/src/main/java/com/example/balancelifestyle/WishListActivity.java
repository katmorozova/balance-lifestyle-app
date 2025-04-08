package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class WishListActivity extends AppCompatActivity {

    private ImageButton imageButtonProjects;
    private ImageButton imageButtonBooks;
    private ImageButton imageButtonFilms;
    private RecyclerView recyclerViewProjects;
    private RecyclerView recyclerViewBooks;
    private RecyclerView recyclerViewFilms;

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
        setUpclickListeners();
    }

    public void initViews(){
        imageButtonProjects = findViewById(R.id.imageButtonProjects);
        imageButtonBooks = findViewById(R.id.imageButtonBooks);
        imageButtonFilms = findViewById(R.id.imageButtonFilms);
        recyclerViewProjects = findViewById(R.id.recyclerViewProjects);
        recyclerViewBooks = findViewById(R.id.recyclerViewBooks);
        recyclerViewFilms = findViewById(R.id.recyclerViewFilms);
    }

    public static Intent newIntent(Context context){
        return new Intent(context, WishListActivity.class);
    }

    private void setUpclickListeners(){
        imageButtonProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddWishListActivity.newIntent(WishListActivity.this);
                intent.putExtra("category", "projects");
                startActivity(intent);
                finish();
            }
        });
        imageButtonBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddWishListActivity.newIntent(WishListActivity.this);
                intent.putExtra("category", "books");
                startActivity(intent);
                finish();
            }
        });
        imageButtonFilms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddWishListActivity.newIntent(WishListActivity.this);
                intent.putExtra("category", "films");
                startActivity(intent);
                finish();
            }
        });
    }
}