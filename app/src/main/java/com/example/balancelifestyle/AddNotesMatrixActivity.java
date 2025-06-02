package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.balancelifestyle.database.NotesMatrixList;

public class AddNotesMatrixActivity extends AppCompatActivity {

    private EditText editTextAddNoteMatrix;
    private RadioButton radioButtonDoNow;
    private RadioButton radioButtonPlaning;
    private RadioButton radioButtonDelegate;
    private RadioButton radioButtonDelete;
    private Button buttonAddNoteMatrix;

    private AddNotesMatrixViewModel viewModel;

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
        viewModel = new ViewModelProvider(this).get(AddNotesMatrixViewModel.class);
        setOnClickListeners();
    }

    private void initViews(){
        editTextAddNoteMatrix = findViewById(R.id.editTextAddNoteMatrix);
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

        if(radioButtonDoNow.isChecked() && radioButtonDoNow != null){
            typeOfMatrixList = 0;
        }else if(radioButtonPlaning.isChecked() && radioButtonPlaning != null){
            typeOfMatrixList = 1;
        }else if(radioButtonDelegate.isChecked() && radioButtonDelegate != null) {
            typeOfMatrixList = 2;
        }else if(radioButtonDelete.isChecked() && radioButtonDelete != null) {
            typeOfMatrixList = 3;
        }
        return typeOfMatrixList;
    }

    private void setOnClickListeners(){
        buttonAddNoteMatrix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.saveNoteMatrix(new NotesMatrixList(0, "Ejemplo nota Do Now", 0));

                Intent intent = GoalsActivity.newIntent(AddNotesMatrixActivity.this);
                startActivity(intent);
                finish();
            }
        });
    }

    private void saveNoteMatrix(){
        String text = editTextAddNoteMatrix.getText().toString().trim();
        if(text.isEmpty()){
            Toast.makeText(this, "Introduce titulo y nota", Toast.LENGTH_SHORT).show();
        }else{
            NotesMatrixList notesMatrixList = new NotesMatrixList(
                    0,
                    text,
                    getTypeOfNoteMatrixList()
            );
            viewModel.saveNoteMatrix(notesMatrixList);
        }


    }
    public void observeViewModel(){
        viewModel.getShouldCloseScreen().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean shouldClose) {
                if(shouldClose){
                    finish();
                }
            }
        });
    }


}