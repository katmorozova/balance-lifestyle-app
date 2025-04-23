package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.balancelifestyle.database.ToDoList;

public class AddToDoActivity extends AppCompatActivity {

    private EditText editTextAddNote;
    private RadioButton radioButtonHighPriority;
    private RadioButton radioButtonMediumPriority;
    private RadioButton radioButtonLowPriority;
    private Button buttonSaveNote;

    private AddToDoViewModel viewModel;

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
        viewModel = new ViewModelProvider(this).get(AddToDoViewModel.class);
        observeViewModel();
        setUpClickListeners();
    }

    private void initViews(){
        editTextAddNote = findViewById(R.id.editTextAddNote);
        radioButtonHighPriority = findViewById(R.id.radioButtonHighPriority);
        radioButtonMediumPriority = findViewById(R.id.radioButtonMediumPriority);
        radioButtonLowPriority = findViewById(R.id.radioButtonLowPriority);
        buttonSaveNote = findViewById(R.id.buttonSaveNote);
    }

    public static Intent newIntent(Context context){
        return new Intent(context, AddToDoActivity.class);
    }

    private int getTypeOfToDoList(){
        int typeOfList = -1;
        if(radioButtonHighPriority.isChecked()){
            typeOfList = 0;
        }else if(radioButtonMediumPriority.isChecked()){
            typeOfList = 1;
        }else if(radioButtonLowPriority.isChecked()) {
            typeOfList = 2;
        }
        return typeOfList;
    }

    private void setUpClickListeners(){
        buttonSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveToDoList();
                Intent intent = ToDoActivity.newIntent(AddToDoActivity.this);
                startActivity(intent);
                finish();
            }
        });
    }

    private void saveToDoList(){
        String text = editTextAddNote.getText().toString().trim();
        int typeOfList = getTypeOfToDoList();
        ToDoList toDoList = new ToDoList(0, text, typeOfList);
        viewModel.saveToDoList(toDoList);

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