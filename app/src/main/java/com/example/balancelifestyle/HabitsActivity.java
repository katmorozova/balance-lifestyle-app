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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class HabitsActivity extends AppCompatActivity {

    private RecyclerView recyclerViewHabits;
    private FloatingActionButton floatingActionButtonHabits;
    private HabitsAdapter habitsAdapter;

    private HabitsViewModel viewModel;

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
        viewModel = new ViewModelProvider(this).get(HabitsViewModel.class);
        initViews();
        habitsAdapter = new HabitsAdapter();

        recyclerViewHabits.setAdapter(habitsAdapter);
        observeViewModel();
        setupItemTouchHelper();

    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.refreshList();
    }

    private void  initViews(){
        recyclerViewHabits = findViewById(R.id.recyclerViewHabits);
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
                Habit habit = habitsAdapter.getHabits().get(position);
                viewModel.remove(habit);
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerViewHabits);
        setUpClickListeners();
    }

    public void observeViewModel(){
        viewModel.getHabits().observe(this, new Observer<List<Habit>>() {
            @Override
            public void onChanged(List<Habit> habits) {
                habitsAdapter.setHabits(habits);
            }
        });
    }

}