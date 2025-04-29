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

    private LinearLayout layoutUrgentImportant;
    private LinearLayout layoutNotUrgentImportant;
    private LinearLayout layoutUrgentNotImportant;
    private LinearLayout layoutNotUrgentNotImportant;

    private RecyclerView recyclerViewUrgentImportant;
    private RecyclerView recyclerViewUrgentNotImportant;
    private RecyclerView recyclerViewNotUrgentImportant;
    private RecyclerView recyclerViewNotUrgentNotImportant;

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
        setUpRecyclerViews();
        setUpClickListeners();
    }

    public void initViews(){
        layoutUrgentImportant = findViewById(R.id.layoutUrgentImportant);
        layoutNotUrgentImportant = findViewById(R.id.layoutNotUrgentImportant);
        layoutUrgentNotImportant = findViewById(R.id.layoutUrgentNotImportant);
        layoutNotUrgentNotImportant = findViewById(R.id.layoutNotUrgentNotImportant);
        recyclerViewUrgentImportant = findViewById(R.id.recyclerViewUrgentImportant);
        recyclerViewUrgentNotImportant = findViewById(R.id.recyclerViewUrgentNotImportant);
        recyclerViewNotUrgentImportant = findViewById(R.id.recyclerViewNotUrgentImportant);
        recyclerViewNotUrgentNotImportant = findViewById(R.id.recyclerViewNotUrgentNotImportant);
        buttonGoalsOfMonth = findViewById(R.id.buttonGoalsOfMonth);
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

    private void setUpRecyclerViews() {
        GoalsAdapter adapterUrgentImportant = new GoalsAdapter(0);
        recyclerViewUrgentImportant.setAdapter(adapterUrgentImportant);

        GoalsAdapter adapterNotUrgentImportant = new GoalsAdapter(1);
        recyclerViewNotUrgentImportant.setAdapter(adapterNotUrgentImportant);

        GoalsAdapter adapterUrgentNotImportant = new GoalsAdapter(2);
        recyclerViewUrgentNotImportant.setAdapter(adapterUrgentNotImportant);

        GoalsAdapter adapterNotUrgentNotImportant = new GoalsAdapter(3);
        recyclerViewNotUrgentNotImportant.setAdapter(adapterNotUrgentNotImportant);
    }

}