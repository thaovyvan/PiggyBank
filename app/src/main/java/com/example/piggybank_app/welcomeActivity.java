package com.example.piggybank_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class welcomeActivity extends AppCompatActivity {
    public static String welcomeBackName;
    TextView welcomeBackText;

    private AlarmManager alarmManager;
    private PendingIntent alarmIntent;

    private String CHANNEL_ID = "PiggyBank";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcomeBackText = (TextView)findViewById(R.id.welcome_textView);
        Intent intent = getIntent();
        welcomeBackName = intent.getStringExtra("username");
        welcomeBackText.setText("Welcome back " + welcomeBackName);


        //In welcomeActivity for testing purposes
//        if (!AlarmReceiver.hasNotificationAlarm(getApplicationContext())) {
//            AlarmReceiver.setNotificationAlarm(this);
//        }
//        Intent intent1 = new Intent(this, AlarmReceiver.class);
//        //small increments for testing purposes
//        long minute = 1000 * 60;
//        long hour = minute * 60;
//        long delay = minute;
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent1, 0);
//        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + delay, delay, pendingIntent);

    }

    public void goToSettings(View view) {
        Intent intent = new Intent(this, settingsActivity.class);
        startActivity(intent);
    }
}
