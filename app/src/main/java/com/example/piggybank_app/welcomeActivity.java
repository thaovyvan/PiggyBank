package com.example.piggybank_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class welcomeActivity extends AppCompatActivity {

    private TextView welcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeMessage = findViewById(R.id.welcome_textView);
    }

    public void goToSettings(View view) {
        Intent intent = new Intent(this, settingsActivity.class);
        startActivity(intent);
    }

    private void setWelcomeMessage(String str){
        String txt = String.format("Welcome back %s!", str);
        welcomeMessage.setText(txt);
    }
}
