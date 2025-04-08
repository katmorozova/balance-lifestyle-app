package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddWishListActivity extends AppCompatActivity {

    private EditText editTextAddWishList;
    private RadioButton radioButtonProjects;
    private RadioButton radioButtonBooks;
    private RadioButton radioButtonFilms;
    private Button buttonSaveWish;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_wish_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();

        setOnClickListeners();
        setChekedButtons();
    }

    private void initViews(){
        editTextAddWishList = findViewById(R.id.editTextAddWishlist);
        radioButtonProjects = findViewById(R.id.radioButtonProjects);
        radioButtonBooks = findViewById(R.id.radioButtonBooks);
        radioButtonFilms = findViewById(R.id.radioButtonFilms);
        buttonSaveWish = findViewById(R.id.buttonSaveWish);

    }

    public static Intent newIntent(Context context){
        return new Intent(context, AddWishListActivity.class);
    }

    private void setOnClickListeners(){

    }

    public String getTypeOfCategory(){
        String category = "";
        if(radioButtonProjects.isChecked()){
            category = "projects";
        }else if(radioButtonBooks.isChecked()) {
            category = "books";
        }else if(radioButtonFilms.isChecked()) {
            category = "films";
        }
        return category;
    }

    public void setChekedButtons(){
        String category = getIntent().getStringExtra("category");
        if(category != null){
            switch (category){
                case "projects":
                    radioButtonProjects.setChecked(true);
                    break;
                case "books":radioButtonBooks.setChecked(true);
                    break;
                case "films":
                    radioButtonFilms.setChecked(true);
                    break;
            }
        }
    }

}