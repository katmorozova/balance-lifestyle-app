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

    private Database database = new Database();

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
        setUpClickListeners();

    }

    @Override
    protected void onResume() {
        super.onResume();
        showHabits();
    }

    private void  initViews(){
        linearLayoutHabits = findViewById(R.id.linearLayoutHabits);
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
        linearLayoutHabits.removeAllViews();
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
                    colorResId = R.color.verde_nature;
                    break;
                case 1:
                    colorResId = R.color.turquesa_relajante;
                    break;
                case 2:
                    colorResId = R.color.rosa_suave_brillante;
                    break;
                case 3:
                    colorResId = R.color.azul_concentracion;
                    break;
                case 4:
                    colorResId = R.color.morado_equilibrado;
                    break;
                case 5:
                    colorResId = R.color.amarillo_dorado;
                    break;
                case 6:
                    colorResId = R.color.gris_azulado_claro;
                    break;
                default:
                    colorResId = R.color.coral;
            }
            int color = ContextCompat.getColor(this, colorResId);
            textViewHabit.setBackgroundColor(color);
            linearLayoutHabits.addView(view);
        }
    }
}