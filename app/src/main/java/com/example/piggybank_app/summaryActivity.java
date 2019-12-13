package com.example.piggybank_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

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

        updateSummaryLayout(80, 15, 5);
    }

    /**
     * @param social percentage of spending on social media
     * @param games  percentage of spending on games
     * @param photos percentage of spending on photos/videos
     */
    public void updateSummaryLayout(int social, int games, int photos) {
        TextView socialPercentage = findViewById(R.id.socialMediaPercentage);
        TextView gamesPercentage = findViewById(R.id.gamesPercentage);
        TextView photoPercentage = findViewById(R.id.photoPercentage);

        socialPercentage.setText(String.format(Locale.US,"%d%%", social));
        gamesPercentage.setText(String.format(Locale.US,"%d%%", games));
        photoPercentage.setText(String.format(Locale.US,"%d%%", photos));

        //meant to rearrange the ViewGroups/LinearLayouts that contain the different types of spending so the largest percentages are at the top
    }
}
