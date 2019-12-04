package com.example.piggybank_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class settingsActivity extends AppCompatActivity {

    Spinner timeIncrementSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        timeIncrementSpinner = findViewById(R.id.timeIncrementSpinner);
        ArrayAdapter<CharSequence> timeIncrementAdapter = ArrayAdapter.createFromResource(this,
                R.array.timeIncrement_array, android.R.layout.simple_spinner_item);
        timeIncrementAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeIncrementSpinner.setAdapter(timeIncrementAdapter);

        Button updateSettingButton = findViewById(R.id.updateSettingsButton);
        updateSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
