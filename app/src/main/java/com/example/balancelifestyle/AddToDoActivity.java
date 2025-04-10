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

public class AddToDoActivity extends AppCompatActivity {

    private EditText editTextAddNote;
    private RadioButton radioButtonHighPriority;
    private RadioButton radioButtonMediumPriority;
    private RadioButton radioButtonLowPriority;
    private Button buttonSaveNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_to_do);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
    }

    private void initViews(){
        editTextAddNote = findViewById(R.id.editTextAddNote);
        radioButtonHighPriority = findViewById(R.id.radioButtonHighPriority);
        radioButtonMediumPriority = findViewById(R.id.radioButtonMediumPriority);
        radioButtonLowPriority = findViewById(R.id.radioButtonLowPriority);
        buttonSaveNote = findViewById(R.id.buttonAddNote);
    }

    public static Intent newIntent(Context context){
        return new Intent(context, AddToDoActivity.class);
    }
}