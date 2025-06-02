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
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.balancelifestyle.database.NotesMatrixList;

import java.util.ArrayList;
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


    //private GoalsAdapter goalsAdapter = new GoalsAdapter();
    private DoNowAdapter doNowAdapter;
    private PlanningAdapter planningAdapter;
    private DelegateAdapter delegateAdapter;
    private DeleteAdapter deleteAdapter;

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
        setupItemTouchDoNowHelper();
        setupItemTouchPlanningHelper();
        setupItemTouchDelegateHelper();
        setupItemTouchDeleteHelper();
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
                finish();

            }
        });
        linearLayoutPlaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNotesMatrixActivity.newIntent(GoalsActivity.this);
                intent.putExtra("typeOfMatrixList", 1);
                startActivity(intent);
                finish();
            }
        });
        linearLayoutDelegate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNotesMatrixActivity.newIntent(GoalsActivity.this);
                intent.putExtra("typeOfMatrixList", 2);
                startActivity(intent);
                finish();
            }
        });
        linearLayoutDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNotesMatrixActivity.newIntent(GoalsActivity.this);
                intent.putExtra("typeOfMatrixList", 3);
                startActivity(intent);
                finish();
            }
        });
        buttonGoalsOfMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddGoalsOfMonthActivity.newIntent(GoalsActivity.this);
                startActivity(intent);
            }
        });
    }

    private void observeViewModel(){
        viewModel.getDoNowList().observe(
                this,
                new Observer<List<NotesMatrixList>>() {
            @Override
            public void onChanged(List<NotesMatrixList> doNowList) {
                if (doNowAdapter != null) {
                    doNowAdapter.setNotesMatrixLists(new ArrayList<>()); // Limpiar datos antiguos
                    doNowAdapter.setNotesMatrixLists(doNowList);
                } else {
                    Log.e("GoalsActivity", "DoNoewAdapter es nulo");
                }
            }
        });
        viewModel.getPlanningList().observe(
                this,
                new Observer<List<NotesMatrixList>>() {
            @Override
            public void onChanged(List<NotesMatrixList> planningList) {
                if (planningAdapter != null) {
                    planningAdapter.setNotesMatrixLists(new ArrayList<>());
                    planningAdapter.setNotesMatrixLists(planningList);
                } else {
                    Log.e("GoalsActivity", "PlanningAdapter es nulo");
                }
            }
        });
        viewModel.getDelegateList().observe(
                this,
                new Observer<List<NotesMatrixList>>() {
            @Override
            public void onChanged(List<NotesMatrixList> delegateList) {
                if (delegateAdapter != null) {
                    delegateAdapter.setNotesMatrixLists(new ArrayList<>());// Clonar lista
                    delegateAdapter.setNotesMatrixLists(delegateList);
                } else {
                    Log.e("GoalsActivity", "DelegateAdapter es nulo");
                }
            }
        });
        viewModel.getDeleteList().observe(
                this,
                new Observer<List<NotesMatrixList>>() {
            @Override
            public void onChanged(List<NotesMatrixList> deleteList) {
                if (deleteAdapter != null) {
                    deleteAdapter.setNotesMatrixLists(new ArrayList<>());
                    deleteAdapter.setNotesMatrixLists(deleteList);
                } else {
                    Log.e("GoalsActivity", "DeleteAdapter es nulo");
                }
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        refreshDatesOfNotes();

    }

    private void refreshDatesOfNotes() {//este metodo tiene que insertar nota por su categoria
        Log.d("GoalsActivity", "Actualizando lista de notas...");
        viewModel.refreshNotesMatrixList(0);
        viewModel.refreshNotesMatrixList(1);
        viewModel.refreshNotesMatrixList(2);
        viewModel.refreshNotesMatrixList(3);
    }



    private void setAdapters(){
        doNowAdapter = new DoNowAdapter();
        planningAdapter = new PlanningAdapter();
        delegateAdapter = new DelegateAdapter();
        deleteAdapter = new DeleteAdapter();

        recyclerViewDoNow.setAdapter(doNowAdapter);
        recyclerViewPlaning.setAdapter(planningAdapter);
        recyclerViewDelegate.setAdapter(delegateAdapter);
        recyclerViewDelete.setAdapter(deleteAdapter);
    }

    private void setupItemTouchDoNowHelper(){
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

                if (position >= 0 && position < doNowAdapter.getNotesMatrixLists().size()) {
                    NotesMatrixList doNowList = doNowAdapter.getNotesMatrixLists().get(position);
                    viewModel.remove(doNowList);
                    doNowAdapter.notifyItemRemoved(position);
                } else {
                    Log.e(
                            "GoalsActivity",
                            "Posición fuera de los límites para doNowAdapter"
                    );
                }
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerViewDoNow);


    }

    private void setupItemTouchPlanningHelper(){
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

                if (position >= 0 && position < planningAdapter.getNotesMatrixLists().size()) {
                    NotesMatrixList planningList = planningAdapter
                            .getNotesMatrixLists().get(position);
                    viewModel.remove(planningList);
                    planningAdapter.notifyItemRemoved(position);
                } else {
                    Log.e(
                            "GoalsActivity",
                            "Posición fuera de los límites para planningAdapter." +
                                    " Tamaño de la lista: " +
                                    planningAdapter.getNotesMatrixLists().size() +
                                    ", posición: " + position
                    );
                }
            }

        });
        itemTouchHelper.attachToRecyclerView(recyclerViewPlaning);
    }

    private void setupItemTouchDelegateHelper(){
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

                if (position >= 0 && position < delegateAdapter.getNotesMatrixLists().size()) {
                    NotesMatrixList delegateList = delegateAdapter
                            .getNotesMatrixLists().get(position);
                    viewModel.remove(delegateList);
                    delegateAdapter.notifyItemRemoved(position);
                } else {
                    Log.e(
                            "GoalsActivity",
                            "Posición fuera de los límites para delegateAdapter"
                    );
                }

            }

        });
        itemTouchHelper.attachToRecyclerView(recyclerViewDelegate);
    }
    private void setupItemTouchDeleteHelper(){
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

                if (position >= 0 && position < deleteAdapter.getNotesMatrixLists().size()) {
                    NotesMatrixList deleteList = deleteAdapter.getNotesMatrixLists().get(position);
                    viewModel.remove(deleteList);
                    deleteAdapter.notifyItemRemoved(position);
                } else {
                    Log.e(
                            "GoalsActivity",
                            "Posición fuera de los límites para deleteAdapter"
                    );
                }
            }

        });
        itemTouchHelper.attachToRecyclerView(recyclerViewDelete);

    }

}