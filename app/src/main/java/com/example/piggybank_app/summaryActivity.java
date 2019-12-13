package com.example.piggybank_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.widget.LinearLayout;
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

        updateSummaryLayout(0,0,0);
    }

    /**
     *
     * @param social percentage of spending on social media
     * @param games percentage of spending on games
     * @param photos percentage of spending on photos/videos
     */
    public void updateSummaryLayout(int social, int games, int photos){
        ConstraintLayout  constraintLayout = new ConstraintLayout(this);
        LinearLayout socialGroup = findViewById(R.id.socialMediaGroup);
        LinearLayout gamesGroup = findViewById(R.id.photoGroup);
        LinearLayout photosGroup = findViewById(R.id.gamesGroup);

        ConstraintSet constraintSet = new ConstraintSet();
//        constraintSet.clone(this, R.layout.activity_summary);
        constraintSet.clone(constraintLayout);
        constraintSet.connect(R.id.gamesGroup, ConstraintSet.TOP, R.id.summaryTable, ConstraintSet.BOTTOM);
        constraintSet.connect(R.id.socialMediaGroup, ConstraintSet.TOP, R.id.gamesGroup, ConstraintSet.BOTTOM);
        constraintSet.connect(R.id.photoGroup, ConstraintSet.TOP, R.id.photoGroup, ConstraintSet.BOTTOM);
        constraintSet.applyTo(constraintLayout);

    }
}
