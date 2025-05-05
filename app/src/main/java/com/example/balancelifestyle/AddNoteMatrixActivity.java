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

import com.example.balancelifestyle.database.NoteMatrix;

public class AddNoteMatrixActivity extends AppCompatActivity {

    private EditText editTextAddNoteMatrix;
    private RadioButton radioButtonUrgentImportant;
    private RadioButton radioButtonNotUrgentImportant;
    private RadioButton radioButtonUrgentNotImportant;
    private RadioButton radioButtonNotUrgentNotImportant;
    private Button buttonAddMatrix;

    private AddNoteMatrixViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_note_matrix);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        viewModel = new ViewModelProvider(this).get(AddNoteMatrixViewModel.class);
        setCheckedButtons();
        setOnClickListeners();
    }

    private void initViews(){
        editTextAddNoteMatrix = findViewById(R.id.editTextAddNoteMatrix);
        radioButtonUrgentImportant = findViewById(R.id.radioButtonUrgentImportant);
        radioButtonNotUrgentImportant = findViewById(R.id.radioButtonNotUrgentImportant);
        radioButtonUrgentNotImportant = findViewById(R.id.radioButtonUrgentNotImportant);
        radioButtonNotUrgentNotImportant = findViewById(R.id.radioButtonNotUrgentNotImportant);
        buttonAddMatrix = findViewById(R.id.buttonAddMatrix);
    }

    public static Intent newIntent(Context context){
        return new Intent(context, AddNoteMatrixActivity.class);
    }

    public String getTypeOfCategory(){
        String category = "";
        if(radioButtonUrgentImportant.isChecked()){
            category = "UrgentImportant";
        }else if(radioButtonNotUrgentImportant.isChecked()) {
            category = "NotUrgentImportant";
        }else if(radioButtonUrgentNotImportant.isChecked()) {
            category = "UrgentNotImportant";
        }else if(radioButtonNotUrgentNotImportant.isChecked()) {
            category = "NotUrgentNotImportant";
        }
        return category;
    }

    public void setCheckedButtons(){

        String category = getIntent().getStringExtra("category");
        if(category != null){
            switch (category){
                case "UrgentImportant":
                    radioButtonUrgentImportant.setChecked(true);
                    break;
                case "NotUrgentImportant":
                    radioButtonNotUrgentImportant.setChecked(true);
                    break;
                case "UrgentNotImportant":
                    radioButtonUrgentNotImportant.setChecked(true);
                    break;
                case "NotUrgentNotImportant":
                    radioButtonNotUrgentNotImportant.setChecked(true);
                    break;
            }
        }
    }
    private void setOnClickListeners(){
        buttonAddMatrix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNoteMatrix();
                String category = getTypeOfCategory();
                Intent intent = GoalsActivity.newIntent(AddNoteMatrixActivity.this);
                intent.putExtra("category", category);
                startActivity(intent);
                finish();


            }
        });
    }


        private void saveNoteMatrix(){
        //añadir validacion si usuario ha introducido algo en EditText
        String text = editTextAddNoteMatrix.getText().toString().trim();
        if(text.isEmpty()){
            Toast.makeText(this, "Rellena campo de nota", Toast.LENGTH_SHORT).show();
        }else{
            String category = getTypeOfCategory();
            NoteMatrix noteMatrix = new NoteMatrix(0, text, category);
            switch (category) {
                case "UrgentImportant":
                    viewModel.saveNoteMatrix(noteMatrix);
                    break;
                case "NotUrgentImportant":
                    viewModel.saveNoteMatrix(noteMatrix);
                    break;
                case "UrgentNotImportant":
                    viewModel.saveNoteMatrix(noteMatrix);
                    break;
                case "NotUrgentNotImportant":
                    viewModel.saveNoteMatrix(noteMatrix);
                    break;
            }


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