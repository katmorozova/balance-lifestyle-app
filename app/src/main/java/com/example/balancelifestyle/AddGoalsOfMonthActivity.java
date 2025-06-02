package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddGoalsOfMonthActivity extends AppCompatActivity {

    private EditText editTextAddGoals;
    private EditText editTextAddDate;
    private EditText editTextAddProposite;
    private EditText editTextAddRecompence;
    private EditText edittextAddAction0;
    private EditText edittextAddAction1;
    private EditText edittextAddAction2;
    private EditText edittextAddAction3;
    private EditText edittextAddAction4;
    private Button buttonSaveGoalsMonth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_goals_of_month);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
    }


    private void initViews(){
        editTextAddGoals = findViewById(R.id.editTextAddGoals);
        editTextAddDate = findViewById(R.id.editTextAddDate);
        editTextAddProposite = findViewById(R.id.editTextAddProposite);
        editTextAddRecompence = findViewById(R.id.editTextAddRecompence);
        edittextAddAction0 = findViewById(R.id.edittextAddAction0);
        edittextAddAction1 = findViewById(R.id.edittextAddAction1);
        edittextAddAction2 = findViewById(R.id.edittextAddAction2);
        edittextAddAction3 = findViewById(R.id.edittextAddAction3);
        edittextAddAction4 = findViewById(R.id.edittextAddAction4);
        buttonSaveGoalsMonth = findViewById(R.id.buttonSaveGoalsMonth);
    }

    public static Intent newIntent(Context context){
        return new Intent(context, AddGoalsOfMonthActivity.class);
    }
}