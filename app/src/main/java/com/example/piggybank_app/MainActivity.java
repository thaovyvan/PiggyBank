package com.example.piggybank_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText usernameET, passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameET = findViewById(R.id.username_editText);
        passwordET = findViewById(R.id.password_editText);
    }

    public void signInRegister(View view) {

        Intent intent = new Intent(this, welcomeActivity.class);

        startActivity(intent);
    }
}
