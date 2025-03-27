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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HabitsActivity extends AppCompatActivity {

    private LinearLayout linearLayoutHabits;
    private FloatingActionButton floatingActionButtonHabits;

    private List<Habit> habits = new ArrayList<>();

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

        Random random = new Random();
        for(int i = 0; i < 20; i++){
            Habit habit = new Habit(i, "Habit"+i, random.nextInt(3));
            habits.add(habit);
        }
        showHabits();

    }

    private void  initViews(){
        linearLayoutHabits = findViewById(R.id.linearLayoutHabits);
        floatingActionButtonHabits = findViewById(R.id.floatingActionButtonHabits);
    }

    public static Intent newIntent(Context context){
        return new Intent(context, HabitsActivity.class);
    }

    private  void showHabits(){
        for(Habit habit : habits){
            View view = getLayoutInflater().inflate(
                    R.layout.habit_item,
                    linearLayoutHabits,
                    false
            );
            TextView textViewHabit = view.findViewById(R.id.textViewHabit);
            textViewHabit.setText(habit.getText());
            int colorResId;
            switch(habit.getTypeOfHabit()){
                case 0:
                    colorResId = android.R.color.holo_green_dark;
                    break;
                case 1:
                    colorResId = android.R.color.holo_orange_dark;
                    break;
                case 2:
                    colorResId = android.R.color.holo_blue_dark;
                    break;
                default:
                    colorResId = android.R.color.holo_purple;
            }
            int color = ContextCompat.getColor(this, colorResId);
            textViewHabit.setBackgroundColor(color);
            linearLayoutHabits.addView(view);
        }
    }
}