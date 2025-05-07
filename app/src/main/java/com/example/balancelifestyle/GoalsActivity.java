package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

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

    private LinearLayout layoutUrgentImportant;
    private LinearLayout layoutNotUrgentImportant;
    private LinearLayout layoutUrgentNotImportant;
    private LinearLayout layoutNotUrgentNotImportant;

    private RecyclerView recyclerViewUrgentImportant;
    private RecyclerView recyclerViewUrgentNotImportant;
    private RecyclerView recyclerViewNotUrgentImportant;
    private RecyclerView recyclerViewNotUrgentNotImportant;

    private Button buttonGoalsOfMonth;

    private GoalsAdapter adapterUrgentImportant;
    private GoalsAdapter adapterNotUrgentImportant;
    private GoalsAdapter adapterUrgentNotImportant;
    private GoalsAdapter adapterNotUrgentNotImportant;

    private GoalsViewModel viewModel;


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
        viewModel = new ViewModelProvider(this).get(GoalsViewModel.class);
        setUpRecyclerViews();
        observeViewModel();
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
                intent.putExtra("category", "UrgentImportant");
                startActivity(intent);
            }
        });

        layoutNotUrgentImportant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNoteMatrixActivity.newIntent(GoalsActivity.this);
                intent.putExtra("category", "NotUrgentImportant");
                startActivity(intent);
            }
        });

        layoutUrgentNotImportant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNoteMatrixActivity.newIntent(GoalsActivity.this);
                intent.putExtra("category", "UrgentNotImportant");
                startActivity(intent);
            }
        });

        layoutNotUrgentNotImportant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNoteMatrixActivity.newIntent(GoalsActivity.this);
                intent.putExtra("category", "NotUrgentNotImportant");
                startActivity(intent);
            }
        });
    }

    private void setUpRecyclerViews() {
        recyclerViewUrgentImportant.setLayoutManager(new LinearLayoutManager(this));
        adapterUrgentImportant = new GoalsAdapter("UrgentImportant");
        recyclerViewUrgentImportant.setAdapter(adapterUrgentImportant);

        recyclerViewNotUrgentImportant.setLayoutManager(new LinearLayoutManager(this));
        adapterNotUrgentImportant = new GoalsAdapter("NotUrgentImportant");
        recyclerViewNotUrgentImportant.setAdapter(adapterNotUrgentImportant);

        recyclerViewUrgentNotImportant.setLayoutManager(new LinearLayoutManager(this));
        adapterUrgentNotImportant = new GoalsAdapter("UrgentNotImportant");
        recyclerViewUrgentNotImportant.setAdapter(adapterUrgentNotImportant);


        recyclerViewNotUrgentNotImportant.setLayoutManager(new LinearLayoutManager(this));
        adapterNotUrgentNotImportant = new GoalsAdapter("NotUrgentNotImportant");
        recyclerViewNotUrgentNotImportant.setAdapter(adapterNotUrgentNotImportant);
    }

    private void observeViewModel(){
        viewModel.getNoteMatrices().observe(this, new Observer<List<NoteMatrix>>() {
            @Override
            public void onChanged(List<NoteMatrix> noteMatrices) {
                adapterUrgentImportant.setNoteMatrices(
                        filterNotesByCategory(noteMatrices, "UrgentImportant")
                );
                adapterNotUrgentImportant.setNoteMatrices(
                        filterNotesByCategory(noteMatrices, "NotUrgentImportant")
                );
                adapterUrgentNotImportant.setNoteMatrices(
                        filterNotesByCategory(noteMatrices, "UrgentNotImportant")
                );
                adapterNotUrgentNotImportant.setNoteMatrices(
                        filterNotesByCategory(noteMatrices, "NotUrgentNotImportant")
                );
            }
        });
    }

    private List<NoteMatrix> filterNotesByCategory(List<NoteMatrix> notes, String category) {
        List<NoteMatrix> filteredList = new ArrayList<>();
        for (NoteMatrix note : notes) {
            if (note.getCategory().equals(category)) {
                filteredList.add(note);
            }
        }
        return filteredList;
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.refreshNotesMatrix();
    }



}