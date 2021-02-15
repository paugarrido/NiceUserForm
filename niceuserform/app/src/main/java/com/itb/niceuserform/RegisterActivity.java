package com.itb.niceuserform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    EditText usernameRegister;
    EditText passwordRegister;
    EditText repeatPasswordRegister;
    EditText emailRegister;
    EditText nameRegister;
    EditText surnamesRegister;
    EditText birthDateRegister;
    CheckBox checkBoxRegister;
    Button buttonRegisterScreenRegister;
    Button buttonRegisterScreenLogin;
    Spinner spinnerGender;

    TextInputLayout textFieldUsernameRegister;
    TextInputLayout textFieldPasswordRegister;
    TextInputLayout textFieldRepeatPasswordRegister;
    TextInputLayout textFieldEmailRegister;
    TextInputLayout textFieldNameRegister;
    TextInputLayout textFieldSurnamesRegister;
    TextInputLayout textFieldBirthDateRegister;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameRegister = findViewById(R.id.editTextUsernameRegister);
        passwordRegister = findViewById(R.id.editTextPasswordRegister);
        repeatPasswordRegister = findViewById(R.id.editTextRepeatPasswordRegister);
        emailRegister = findViewById(R.id.editTextEmailRegister);
        nameRegister = findViewById(R.id.editTextNameRegister);
        surnamesRegister = findViewById(R.id.editTextSurnamesRegister);
        checkBoxRegister = findViewById(R.id.checkBoxTermps);
        buttonRegisterScreenRegister = findViewById(R.id.RegisterScreenRegister);
        buttonRegisterScreenLogin = findViewById(R.id.RegisterScreenLogin);
        birthDateRegister = findViewById(R.id.editTextBirthDateRegister);
        spinnerGender = findViewById(R.id.spinner);

        textFieldUsernameRegister = findViewById(R.id.textFieldUsernameRegister);
        textFieldPasswordRegister = findViewById(R.id.textFieldPasswordRegister);
        textFieldRepeatPasswordRegister = findViewById(R.id.textFieldRepeatPassword);
        textFieldEmailRegister = findViewById(R.id.textFieldEmail);
        textFieldNameRegister = findViewById(R.id.textFieldName);
        textFieldSurnamesRegister = findViewById(R.id.textFieldSurnames);
        textFieldBirthDateRegister = findViewById(R.id.textFieldBirthDate);

        birthDateRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        buttonRegisterScreenLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegisterScreenLoginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(RegisterScreenLoginIntent);
            }
        });

        buttonRegisterScreenRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernameRegister.getText().toString().isEmpty()){
                    textFieldUsernameRegister.setError("Required field");
                }else if (passwordRegister.getText().toString().isEmpty()){
                    textFieldPasswordRegister.setError("Required field");
                }else if (repeatPasswordRegister.getText().toString().isEmpty()){
                    textFieldRepeatPasswordRegister.setError("Required field");
                }else if (emailRegister.getText().toString().isEmpty()){
                    textFieldEmailRegister.setError("Required field");
                }else if (nameRegister.getText().toString().isEmpty()){
                    textFieldNameRegister.setError("Required field");
                }else if (surnamesRegister.getText().toString().isEmpty()){
                    textFieldSurnamesRegister.setError("Required field");
                }else if (birthDateRegister.getText().toString().isEmpty()){
                    textFieldBirthDateRegister.setError("Required field");
                }else if (passwordRegister.getText().toString().length() < 8){
                    textFieldPasswordRegister.setError("Password must have at least 8 characters");
                }else if(repeatPasswordRegister.getText().toString().length() < 8){
                    textFieldRepeatPasswordRegister.setError("Password must have at least 8 characters");
                } else if (!passwordRegister.getText().toString().equals(repeatPasswordRegister.getText().toString())){
                    textFieldPasswordRegister.setError("Password must be equals");
                    textFieldRepeatPasswordRegister.setError("Password must be equals");
                }else if(!checkBoxRegister.isChecked()){
                    Toast.makeText(RegisterActivity.this, "You have to accept the terms and conditions", Toast.LENGTH_SHORT).show();
                }else {
                    Intent RegisterRegisterIntent = new Intent(RegisterActivity.this, WelcomeActivity.class);
                    RegisterRegisterIntent.putExtra("username", usernameRegister.getText().toString());
                    startActivity(RegisterRegisterIntent);
                }
            }
        });
    }


    private void showDatePickerDialog(){
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                birthDateRegister.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");

    }
}