package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddNoteMatrixActivity extends AppCompatActivity {

    private EditText editTextAddNoteMatrix;
    private RadioButton radioButtonUrgentImportant;
    private RadioButton radioButtonNotUrgentImportant;
    private RadioButton radioButtonUrgentNotImportant;
    private RadioButton radioButtonNotUrgentNotImportant;
    private Button buttonAddMatrix;

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
}