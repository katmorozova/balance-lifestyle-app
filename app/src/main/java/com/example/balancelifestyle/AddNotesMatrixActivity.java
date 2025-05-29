package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddNotesMatrixActivity extends AppCompatActivity {

    private EditText editTextAddNoteMatrix;
    private RadioGroup radioGroupMatrix;
    private RadioButton radioButtonDoNow;
    private RadioButton radioButtonPlaning;
    private RadioButton radioButtonDelegate;
    private RadioButton radioButtonDelete;
    private Button buttonAddNoteMatrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_notes_matrix);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        setCheckedButtons();
    }

    private void initViews(){
        editTextAddNoteMatrix = findViewById(R.id.editTextAddNoteMatrix);
        radioGroupMatrix = findViewById(R.id.radioGroupMatrix);
        radioButtonDoNow = findViewById(R.id.radioButtonDoNow);
        radioButtonPlaning = findViewById(R.id.radioButtonPlaning);
        radioButtonDelegate = findViewById(R.id.radioButtonDelegate);
        radioButtonDelete = findViewById(R.id.radioButtonDelete);
        buttonAddNoteMatrix = findViewById(R.id.buttonAddNoteMatrix);
    }

    public static Intent newIntent(Context context){
        return new Intent(context, AddNotesMatrixActivity.class);
    }

    private int getTypeOfNoteMatrixList(){
        int typeOfMatrixList = -1;
        if(radioButtonDoNow.isChecked()){
            typeOfMatrixList = 0;
        }else if(radioButtonPlaning.isChecked()){
            typeOfMatrixList = 1;
        }else if(radioButtonDelegate.isChecked()) {
            typeOfMatrixList = 2;
        }else if(radioButtonDelete.isChecked()) {
            typeOfMatrixList = 3;
        }
        return typeOfMatrixList;
    }

    public void setCheckedButtons(){
        int typeOfMatrixList = getIntent().getIntExtra("typeOfMatrixList", -1);
        if(typeOfMatrixList != -1){
            switch (typeOfMatrixList){
                case 0:
                    radioButtonDoNow.setChecked(true);
                    break;
                case 1:
                    radioButtonPlaning.setChecked(true);
                    break;
                case 2:
                    radioButtonDelegate.setChecked(true);
                    break;
                case 3:
                    radioButtonDelete.setChecked(true);
                    break;
            }
        }
    }


}