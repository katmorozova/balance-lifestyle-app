package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.balancelifestyle.database.NoteMatrix;

import java.util.ArrayList;
import java.util.List;

public class GoalsActivity extends AppCompatActivity {

    private TextView textViewUrgentImportant;
    private TextView textViewNotUrgentImportant;
    private TextView textViewUrgentNotImportant;
    private TextView textViewNotUrgentNotImportant;
/*

    private RecyclerView recyclerViewUrgentNotImportant;
    private RecyclerView recyclerViewNotUrgentImportant;
    private RecyclerView recyclerViewNotUrgentNotImportant;

 */

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
        textViewUrgentImportant = findViewById(R.id.textViewUrgentImportant);
        textViewNotUrgentImportant = findViewById(R.id.textViewNotUrgentImportant);
        textViewUrgentNotImportant = findViewById(R.id.textViewUrgentNotImportant);
        textViewNotUrgentNotImportant = findViewById(R.id.textViewNotUrgentNotImportant);
        buttonGoalsOfMonth = findViewById(R.id.buttonGoalsOfMonth);
    }

    public static Intent newIntent(Context context){
        return new Intent(context, GoalsActivity.class);
    }


    private void setUpClickListeners(){
        textViewUrgentImportant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = UrgentImportantActivity.newIntent(GoalsActivity.this);
                intent.putExtra("category", "UrgentImportant");
                startActivity(intent);
            }
        });

        textViewNotUrgentImportant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNoteMatrixActivity.newIntent(GoalsActivity.this);
                intent.putExtra("category", "NotUrgentImportant");
                startActivity(intent);
            }
        });

        textViewUrgentNotImportant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNoteMatrixActivity.newIntent(GoalsActivity.this);
                intent.putExtra("category", "UrgentNotImportant");
                startActivity(intent);
            }
        });

        textViewNotUrgentNotImportant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNoteMatrixActivity.newIntent(GoalsActivity.this);
                intent.putExtra("category", "NotUrgentNotImportant");
                startActivity(intent);
            }
        });
    }

}