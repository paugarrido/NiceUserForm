package com.itb.niceuserform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    EditText usernameLogin;
    EditText passwordLogin;
    Button buttonLoginScreenLogin;
    Button buttonLoginScreenRegister;
    TextInputLayout textFieldPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameLogin = findViewById(R.id.editTextUsernameLogin);
        passwordLogin = findViewById(R.id.editTextPasswordLogin);
        textFieldPassword = findViewById(R.id.textFieldPassword);

        buttonLoginScreenLogin = findViewById(R.id.LoginScreenLogin);
        buttonLoginScreenRegister = findViewById(R.id.LoginScreenRegister);

        buttonLoginScreenLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordLogin.getText().toString().length() < 8){
                    textFieldPassword.setError("Password must have at least 8 characters");
                }
                else{
                    Intent LoginLoginIntent = new Intent(LoginActivity.this, WelcomeActivity.class);
                    LoginLoginIntent.putExtra("username", usernameLogin.getText().toString());
                    startActivity(LoginLoginIntent);
                }
            }
        });

        buttonLoginScreenRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginRegisterIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(LoginRegisterIntent);
            }
        });
    }
}