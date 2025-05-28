package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class GoalsActivity extends AppCompatActivity {

    private LinearLayout linearLayoutDoNow;
    private LinearLayout linearLayoutPlaning;
    private LinearLayout linearLayoutDelegate;
    private LinearLayout linearLayoutDelete;

    private RecyclerView recyclerViewDoNow;
    private RecyclerView recyclerViewPlaning;
    private RecyclerView recyclerViewDelegate;
    private RecyclerView recyclerViewDelete;

    private Button buttonGoalsOfMonth;


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
        linearLayoutDoNow = findViewById(R.id.linearLayoutDoNow);
        linearLayoutPlaning = findViewById(R.id.linearLayoutPlaning);
        linearLayoutDelegate = findViewById(R.id.linearLayoutDelegate);
        linearLayoutDelete = findViewById(R.id.linearLayoutDelete);
        buttonGoalsOfMonth = findViewById(R.id.buttonGoalsOfMonth);
    }

    public static Intent newIntent(Context context){
        return new Intent(context, GoalsActivity.class);
    }

    private void setUpClickListeners(){
        linearLayoutDoNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNotesMatrixActivity.newIntent(GoalsActivity.this);
                startActivity(intent);
            }
        });
        linearLayoutPlaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNotesMatrixActivity.newIntent(GoalsActivity.this);
                startActivity(intent);
            }
        });
        linearLayoutDelegate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNotesMatrixActivity.newIntent(GoalsActivity.this);
                startActivity(intent);
            }
        });
        linearLayoutDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNotesMatrixActivity.newIntent(GoalsActivity.this);
                startActivity(intent);
            }
        });
    }



}