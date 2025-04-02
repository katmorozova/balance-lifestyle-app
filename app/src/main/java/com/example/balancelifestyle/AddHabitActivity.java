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
import androidx.lifecycle.ViewModelProvider;

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

    private AddHabitViewModel viewModel;


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
        viewModel = new ViewModelProvider(this).get(AddHabitViewModel.class);
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
                saveHabit();
                Intent intent = HabitsActivity.newIntent(AddHabitActivity.this);
                startActivity(intent);
            }
        });
    }

    private void saveHabit(){
        //añadir validacion si usuario ha introducido algo en EditText
        String text = editTextAddHabit.getText().toString().trim();
        int typeOfHabit = getTypeOfHabit();
        Habit habit = new Habit(0, text, typeOfHabit); //si pasamos 0 como parametro - autogenerate lo va generar automaticamente
        viewModel.saveHabit(habit);
    }

    private int getTypeOfHabit(){
        int typeOfHabit = -1;
        if(radioButtonSalud.isChecked()){
            typeOfHabit = 0;
        }else if(radioButtonMental.isChecked()){
            typeOfHabit = 1;
        }else if(radioButtonRelaciones.isChecked()){
            typeOfHabit = 2;
        }else if(radioButtonDesarrollo.isChecked()){
            typeOfHabit = 3;
        }else if(radioButtonCreatividad.isChecked()){
            typeOfHabit = 4;
        }else if(radioButtonFinance.isChecked()){
            typeOfHabit = 5;
        }else if(radioButtonHiguiene.isChecked()){
            typeOfHabit = 6;
        }
        return typeOfHabit;
    }

    public static Intent newIntent(Context context){
        return new Intent(context, AddHabitActivity.class);
    }
}