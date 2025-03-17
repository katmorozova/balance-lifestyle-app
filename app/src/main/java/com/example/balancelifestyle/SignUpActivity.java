package com.example.balancelifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextLastName;
    private EditText editTextAge;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSignUp;

    private SignUpViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        viewModel = new ViewModelProvider(this).get(SignUpViewModel.class);
        observeViewModel();
        setUpClickListeners();
    }

    private void initViews(){
        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignUp = findViewById(R.id.buttonSignUp);
    }

    private void setUpClickListeners(){
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = getTrimmedValue(editTextName);
                String lastName = getTrimmedValue(editTextLastName);
                int age = Integer.parseInt(getTrimmedValue(editTextAge));
                String email = getTrimmedValue(editTextEmail);
                String password = getTrimmedValue(editTextPassword);

                viewModel.signUpUser(name, lastName, age, email, password);

                Intent intent = UserActivity.newIntent(SignUpActivity.this);
                startActivity(intent);
            }
        });
    }

    private String getTrimmedValue(EditText editText){
        return editText.getText().toString().trim();
    }

    public static Intent newIntent(Context context){
        return new Intent(context, SignUpActivity.class);
    }

    public void observeViewModel(){
        viewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String errorMessage) {

            }
        });
        viewModel.getUser().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {

            }
        });
    }
}