package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.FirebaseUser;

public class UserActivity extends AppCompatActivity {

    private ImageView imageViewWheelOfLife;
    private ImageView imageViewHabits;
    private ImageView imageViewGratitud;
    private ImageView imageViewGoals;
    private ImageView imageViewPlanning;
    private ImageView imageViewToDo;
    private ImageView imageViewWishlist;
    private ImageView imageViewTravel;
    private ImageView imageViewMenuSemanal;

    private UserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
        initViews();
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        observeViewModel();

    }

    private void observeViewModel(){
        viewModel.getUser().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if(firebaseUser == null){
                    Intent intent = MainActivity.newIntent(UserActivity.this);
                    startActivity(intent);
                    finishAffinity();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item_logout){
            viewModel.logOut();
        }
        if(item.getItemId() == R.id.item_deleteProfile){
            viewModel.deleteUserProfile();
        }
        return super.onOptionsItemSelected(item);
    }

    public static Intent newIntent(Context context){
        return new Intent(context, UserActivity.class);
    }

    private void initViews(){
        imageViewWheelOfLife = findViewById(R.id.imageViewWheelOfLife);
        imageViewHabits = findViewById(R.id.imageViewHabits);
        imageViewGratitud = findViewById(R.id.imageViewGratitud);
        imageViewGoals = findViewById(R.id.imageViewGoals);
        imageViewPlanning = findViewById(R.id.imageViewPlanning);
        imageViewToDo = findViewById(R.id.imageViewToDo);
        imageViewWishlist = findViewById(R.id.imageViewWishlist);
        imageViewTravel = findViewById(R.id.imageViewTravel);
        imageViewMenuSemanal = findViewById(R.id.imageViewMenuSemanal);
    }
}