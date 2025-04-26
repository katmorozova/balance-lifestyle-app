package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class AddWishListActivity extends AppCompatActivity {

    private EditText editTextAddWishListTitle;
    private EditText editTextAddWishListNote;
    private Button buttonSaveWish;

    private AddWishListViewModel viewModel;

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
        viewModel = new ViewModelProvider(this).get(AddWishListViewModel.class);
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
        buttonSaveWish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNote();
                Intent intent = WishListActivity.newIntent(AddWishListActivity.this);
                startActivity(intent);
                finish();
            }
        });

    }

    private void saveNote(){
        String title = editTextAddWishListTitle.getText().toString().trim();
        String text = editTextAddWishListNote.getText().toString().trim();
        if(title.isEmpty() && text.isEmpty()){
            Toast.makeText(this, "Introduce titulo y nota", Toast.LENGTH_SHORT).show();
        }else{
            WishList wishList = new WishList(0, title, text);
            viewModel.saveNote(wishList);
        }

    }



}