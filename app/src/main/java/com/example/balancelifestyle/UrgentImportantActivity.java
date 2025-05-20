package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UrgentImportantActivity extends AppCompatActivity {

    private RecyclerView recyclerViewUrgentImportant;
    private FloatingActionButton fabAddNoteUrgentImportant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_urgent_important);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        setOnClickListeners();
    }

    private void initViews(){
        recyclerViewUrgentImportant = findViewById(R.id.recyclerViewUrgentImportant);
        fabAddNoteUrgentImportant = findViewById(R.id.fabAddNoteUrgentImportant);
    }

    public static Intent newIntent(Context context){
        return new Intent(context, UrgentImportantActivity.class);
    }

    private void setOnClickListeners(){
        fabAddNoteUrgentImportant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNoteMatrixActivity.newIntent(UrgentImportantActivity.this);
                startActivity(intent);
            }
        });

    }
}