package com.itb.niceuserform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView textViewWelcomeUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textViewWelcomeUsername = findViewById(R.id.textViewWelcomeUsername);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            String username = bundle.getString("username");
            textViewWelcomeUsername.setText(username);
        }
    }
}