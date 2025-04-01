package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HabitsActivity extends AppCompatActivity {

    private RecyclerView recyclerViewHabits;
    private FloatingActionButton floatingActionButtonHabits;
    private HabitsAdapter habitsAdapter;

    private Database database = Database.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_habits);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        habitsAdapter = new HabitsAdapter();
        recyclerViewHabits.setAdapter(habitsAdapter);

        setUpClickListeners();

    }

    @Override
    protected void onResume() {
        super.onResume();
        showHabits();
    }

    private void  initViews(){
        recyclerViewHabits = findViewById(R.id.recyclerViewHabits);
        floatingActionButtonHabits = findViewById(R.id.floatingActionButtonHabits);
    }

    public static Intent newIntent(Context context){
        return new Intent(context, HabitsActivity.class);
    }

    private void setUpClickListeners(){
        floatingActionButtonHabits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddHabitActivity.newIntent(HabitsActivity.this);
                startActivity(intent);
            }
        });
    }

    private void showHabits(){
        habitsAdapter.setHabits(database.getHabits());
    }
}