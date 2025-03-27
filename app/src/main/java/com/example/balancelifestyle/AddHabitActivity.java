package com.example.balancelifestyle;

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

public class AddHabitActivity extends AppCompatActivity {

    private EditText editTextAddHabit;
    private RadioButton radioButtonSalud;
    private RadioButton radioButtonMental;
    private RadioButton radioButtonRelaciones;
    private RadioButton radioButtonCreatividad;
    private RadioButton radioButtonFinance;
    private RadioButton radioButtonDesarrollo;
    private RadioButton radioButtonHiguiene;
    private Button buttonSaveHabit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_habit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        setUpClickListeners();
    }


    private void initViews(){
        editTextAddHabit = findViewById(R.id.editTextAddHabit);
        radioButtonSalud = findViewById(R.id.radioButtonSalud);
        radioButtonMental = findViewById(R.id.radioButtonMental);
        radioButtonRelaciones = findViewById(R.id.radioButtonRelaciones);
        radioButtonCreatividad = findViewById(R.id.radioButtonCreatividad);
        radioButtonFinance = findViewById(R.id.radioButtonFinance);
        radioButtonDesarrollo = findViewById(R.id.radioButtonDesarrollo);
        radioButtonHiguiene = findViewById(R.id.radioButtonHiguiene);
        buttonSaveHabit = findViewById(R.id.buttonSaveHabit);
    }
    private void setUpClickListeners(){
        buttonSaveHabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void saveHabit(){
//añadir validacion si usuario ha introducido algo en EditText
        String text = editTextAddHabit.getText().toString().trim();
    }
}