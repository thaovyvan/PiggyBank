package com.example.piggybank_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class summaryActivity extends AppCompatActivity {
    private TextView monthlySpending;
    private TextView socialMediaPercentage, photoPercentage, gamesPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        monthlySpending = findViewById(R.id.monthlySpending);
        socialMediaPercentage = findViewById(R.id.socialMediaPercentage);
        photoPercentage = findViewById(R.id.photoPercentage);
        gamesPercentage = findViewById(R.id.gamesPercentage);
    }
}
