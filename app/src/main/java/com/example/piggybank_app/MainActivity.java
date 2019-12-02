package com.example.piggybank_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static String username;
    public static String password;

    EditText usernameEdit;
    EditText passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEdit = (EditText)findViewById(R.id.username_editText);
        passwordEdit = (EditText)findViewById(R.id.password_editText);
    }

    public void signin_register(View v) {
        Intent intent = new Intent(this, welcomeActivity.class);
        username = usernameEdit.getText().toString();
        password = passwordEdit.getText().toString();
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        startActivity(intent);
    }
}
