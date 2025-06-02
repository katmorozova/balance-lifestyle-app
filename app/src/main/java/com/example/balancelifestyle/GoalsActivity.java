package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.balancelifestyle.database.NotesMatrixList;

import java.util.List;

public class GoalsActivity extends AppCompatActivity {

    private LinearLayout linearLayoutDoNow;
    private LinearLayout linearLayoutPlaning;
    private LinearLayout linearLayoutDelegate;
    private LinearLayout linearLayoutDelete;

    private RecyclerView recyclerViewDoNow;
    private RecyclerView recyclerViewPlaning;
    private RecyclerView recyclerViewDelegate;
    private RecyclerView recyclerViewDelete;


    private GoalsAdapter adapterDoNow;
    private GoalsAdapter adapterPlanning;
    private GoalsAdapter adapterDelegate;
    private GoalsAdapter adapterDelete;

    private Button buttonGoalsOfMonth;

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
        setAdapters();
        observeViewModel();
        setUpClickListeners();

    }

    public void initViews(){
        linearLayoutDoNow = findViewById(R.id.linearLayoutDoNow);
        linearLayoutPlaning = findViewById(R.id.linearLayoutPlaning);
        linearLayoutDelegate = findViewById(R.id.linearLayoutDelegate);
        linearLayoutDelete = findViewById(R.id.linearLayoutDelete);
        buttonGoalsOfMonth = findViewById(R.id.buttonGoalsOfMonth);

        recyclerViewDoNow = findViewById(R.id.recyclerViewDoNow);
        recyclerViewPlaning = findViewById(R.id.recyclerViewPlaning);
        recyclerViewDelegate = findViewById(R.id.recyclerViewDelegate);
        recyclerViewDelete = findViewById(R.id.recyclerViewDelete);


    }

    public static Intent newIntent(Context context){
        return new Intent(context, GoalsActivity.class);
    }

    private void setUpClickListeners(){
        linearLayoutDoNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNotesMatrixActivity.newIntent(GoalsActivity.this);
                intent.putExtra("typeOfMatrixList", 0);
                startActivity(intent);

            }
        });
        linearLayoutPlaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNotesMatrixActivity.newIntent(GoalsActivity.this);
                intent.putExtra("typeOfMatrixList", 1);
                startActivity(intent);
            }
        });
        linearLayoutDelegate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNotesMatrixActivity.newIntent(GoalsActivity.this);
                intent.putExtra("typeOfMatrixList", 2);
                startActivity(intent);
            }
        });
        linearLayoutDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNotesMatrixActivity.newIntent(GoalsActivity.this);
                intent.putExtra("typeOfMatrixList", 3);
                startActivity(intent);
            }
        });
    }

    private void observeViewModel(){
        viewModel.getNotesMatrixLists(0).observe(
                this,
                new Observer<List<NotesMatrixList>>() {
            @Override
            public void onChanged(List<NotesMatrixList> notesMatrixLists) {
                adapterDoNow.setNotesMatrixLists(notesMatrixLists);
            }
        });
        viewModel.getNotesMatrixLists(1).observe(
                this,
                new Observer<List<NotesMatrixList>>() {
            @Override
            public void onChanged(List<NotesMatrixList> notesMatrixLists) {
                adapterPlanning.setNotesMatrixLists(notesMatrixLists);
            }
        });
        viewModel.getNotesMatrixLists(2).observe(
                this,
                new Observer<List<NotesMatrixList>>() {
            @Override
            public void onChanged(List<NotesMatrixList> notesMatrixLists) {
                adapterDelegate.setNotesMatrixLists(notesMatrixLists);
            }
        });
        viewModel.getNotesMatrixLists(3).observe(
                this,
                new Observer<List<NotesMatrixList>>() {
            @Override
            public void onChanged(List<NotesMatrixList> notesMatrixLists) {
                adapterDelete.setNotesMatrixLists(notesMatrixLists);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        refreshDatesOfNotes();

    }

    private void refreshDatesOfNotes() {//este metodo tiene que insertar nota por su categoria


            viewModel.refreshNotesMatrixList(0);
            viewModel.refreshNotesMatrixList(1);
            viewModel.refreshNotesMatrixList(2);
            viewModel.refreshNotesMatrixList(3);

    }



    private void setAdapters(){
       adapterDoNow = new GoalsAdapter();
       adapterPlanning = new GoalsAdapter();
       adapterDelegate = new GoalsAdapter();
       adapterDelete = new GoalsAdapter();

       recyclerViewDoNow.setAdapter(adapterDoNow);
       recyclerViewPlaning.setAdapter(adapterPlanning);
       recyclerViewDelegate.setAdapter(adapterDelegate);
       recyclerViewDelete.setAdapter(adapterDelete);
    }
}