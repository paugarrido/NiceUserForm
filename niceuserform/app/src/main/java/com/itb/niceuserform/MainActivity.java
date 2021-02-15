package com.itb.niceuserform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonLogin;
    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin = findViewById(R.id.HomeScreenLogin);
        buttonRegister = findViewById(R.id.HomeScreenRegister);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomeLoginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(HomeLoginIntent);
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomeRegisterIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(HomeRegisterIntent);
            }
        });
    }
}