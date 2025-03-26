package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserActivity extends AppCompatActivity {

    private TextView textViewUserInfo;
    private ImageView imageViewWheelOfLife;
    private ImageView imageViewHabits;
    private ImageView imageViewThank;
    private ImageView imageViewGoals;
    private ImageView imageViewPlanning;
    private ImageView imageViewToDo;
    private ImageView imageViewWishlist;
    private ImageView imageViewTravel;
    private ImageView imageViewMenuWeek;

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
        loadUserData();
        setUpClickListeners();

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

    public void loadUserData(){
        SharedPreferences preferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String name = preferences.getString("name", "No disponible");
        String lastName = preferences.getString("lastName", "No disponible");
        int age = preferences.getInt("age", -1);

        String userInfo;
        if(age != -1){
            userInfo = getString(R.string.user_info, name, lastName, age);
        }else{
            userInfo = "User no exist!!!";
        }
        textViewUserInfo.setText(userInfo);
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
        textViewUserInfo = findViewById(R.id.textViewUserInfo);
        imageViewWheelOfLife = findViewById(R.id.imageViewWheelOfLife);
        imageViewHabits = findViewById(R.id.imageViewHabits);
        imageViewThank = findViewById(R.id.imageViewThank);
        imageViewGoals = findViewById(R.id.imageViewGoals);
        imageViewPlanning = findViewById(R.id.imageViewPlanning);
        imageViewToDo = findViewById(R.id.imageViewToDo);
        imageViewWishlist = findViewById(R.id.imageViewWishlist);
        imageViewTravel = findViewById(R.id.imageViewTravel);
        imageViewMenuWeek = findViewById(R.id.imageViewMenuWeek);
    }

    private void setUpClickListeners(){
        imageViewWheelOfLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        imageViewHabits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        imageViewThank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        imageViewGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        imageViewPlanning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        imageViewToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        imageViewWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        imageViewTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        imageViewMenuWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}