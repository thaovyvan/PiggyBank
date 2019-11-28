package com.example.piggybank_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class settingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Spinner timeIncrementSpinner = findViewById(R.id.timeIncrementSpinner);
        ArrayAdapter<CharSequence> timeIncrementAdapter = ArrayAdapter.createFromResource(this,
                R.array.timeIncrement_array, android.R.layout.simple_spinner_item);
        timeIncrementAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeIncrementSpinner.setAdapter(timeIncrementAdapter);
    }
}
