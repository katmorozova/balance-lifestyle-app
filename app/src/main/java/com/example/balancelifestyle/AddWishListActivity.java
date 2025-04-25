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

    private EditText editTextAddWishListTitle;
    private EditText editTextAddWishListNote;
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

    }

    private void initViews(){
        editTextAddWishListTitle = findViewById(R.id.editTextAddWishlistTitle);
        editTextAddWishListNote = findViewById(R.id.editTextAddWishlistNote);
        buttonSaveWish = findViewById(R.id.buttonSaveWish);
    }

    public static Intent newIntent(Context context){
        return new Intent(context, AddWishListActivity.class);
    }

    private void setOnClickListeners(){

    }





}