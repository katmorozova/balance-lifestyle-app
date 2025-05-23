package com.example.balancelifestyle;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddNotesMatrixActivity extends AppCompatActivity {

    private EditText editTextAddNoteMatrix;
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
    }

    private void initViews(){
        editTextAddNoteMatrix = findViewById(R.id.editTextAddNoteMatrix);
        radioButtonDoNow = findViewById(R.id.radioButtonDoNow);
        radioButtonPlaning = findViewById(R.id.radioButtonPlaning);
        radioButtonDelegate = findViewById(R.id.radioButtonDelegate);
        radioButtonDelete = findViewById(R.id.radioButtonDelete);
        buttonAddNoteMatrix = findViewById(R.id.buttonAddNoteMatrix);
    }
}