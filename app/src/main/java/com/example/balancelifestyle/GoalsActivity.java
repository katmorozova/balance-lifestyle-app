package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GoalsActivity extends AppCompatActivity {

    private LinearLayout layoutUrgentImportant;
    private LinearLayout layoutNotUrgentImportant;
    private LinearLayout layoutUrgentNotImportant;
    private LinearLayout layoutNotUrgentNotImportant;
    private TextView textViewGoalsOfMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_goals);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        setUpClickListeners();
    }

    public void initViews(){
        layoutUrgentImportant = findViewById(R.id.layoutUrgentImportant);
        layoutNotUrgentImportant = findViewById(R.id.layoutNotUrgentImportant);
        layoutUrgentNotImportant = findViewById(R.id.layoutUrgentNotImportant);
        layoutNotUrgentNotImportant = findViewById(R.id.layoutNotUrgentNotImportant);
        textViewGoalsOfMonth = findViewById(R.id.textViewGoalsOfMonth);
    }

    public static Intent newIntent(Context context){
        return new Intent(context, GoalsActivity.class);
    }


    private void setUpClickListeners(){
        layoutUrgentImportant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNoteMatrixActivity.newIntent(GoalsActivity.this);
                startActivity(intent);
            }
        });
        layoutNotUrgentImportant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNoteMatrixActivity.newIntent(GoalsActivity.this);
                startActivity(intent);
            }
        });
        layoutUrgentNotImportant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNoteMatrixActivity.newIntent(GoalsActivity.this);
                startActivity(intent);
            }
        });
        layoutNotUrgentNotImportant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNoteMatrixActivity.newIntent(GoalsActivity.this);
                startActivity(intent);
            }
        });

    }
}