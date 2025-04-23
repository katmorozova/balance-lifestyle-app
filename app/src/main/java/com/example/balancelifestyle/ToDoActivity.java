package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.balancelifestyle.database.ToDoList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ToDoActivity extends AppCompatActivity {

    private RecyclerView recyclerViewToDo;
    private FloatingActionButton buttonAddNote;

    private ToDoAdapter toDoAdapter;
    private ToDoViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_to_do);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        viewModel = new ViewModelProvider(this).get(ToDoViewModel.class);
        toDoAdapter = new ToDoAdapter();
        recyclerViewToDo.setAdapter(toDoAdapter);
        observeViewModel();
        setupItemTouchHelper();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.refreshToDoList();
    }

    private void initViews(){
        recyclerViewToDo = findViewById(R.id.recyclerViewToDo);
        buttonAddNote = findViewById(R.id.buttonAddNote);
    }

    public static Intent newIntent(Context context){
        return new Intent(context, ToDoActivity.class);
    }

    private void setUpClickListeners(){
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddToDoActivity.newIntent(ToDoActivity.this);
                startActivity(intent);
                finish();
            }
        });
    }

    private void observeViewModel(){
        viewModel.getToDoLists().observe(this, new Observer<List<ToDoList>>() {
            @Override
            public void onChanged(List<ToDoList> toDoLists) {
                toDoAdapter.setToDoLists(toDoLists);
            }
        });
    }

    private void setupItemTouchHelper(){
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT
        ) {
            @Override
            public boolean onMove(
                    @NonNull RecyclerView recyclerView,
                    @NonNull RecyclerView.ViewHolder viewHolder,
                    @NonNull RecyclerView.ViewHolder target
            ) {
                return false;
            }


            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                ToDoList toDoList = toDoAdapter.getToDoLists().get(position);
                viewModel.remove(toDoList);
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerViewToDo);
        setUpClickListeners();
    }

}