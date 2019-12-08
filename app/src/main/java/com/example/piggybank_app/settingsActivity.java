package com.example.piggybank_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;

public class settingsActivity extends AppCompatActivity {
    private Switch notificationsSwitch;
    private Spinner timeIncrementSpinner;

    //Currently the update settings button does the same thing as onBackPressed
    //It should probably be changed so that updateSettings changes the settings while onBackPressed just leaves the activity

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

        notificationsSwitch = findViewById(R.id.notificationSwitch);
        notificationsSwitch.setChecked(AlarmReceiver.hasNotificationAlarm(getApplicationContext()));
        //enable or disable notifications based on whether the notification setting is checked
        notificationsSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (notificationsSwitch.isChecked()){
                    timeIncrementSpinner.setEnabled(true);
                    //Will need to change this later
                    AlarmReceiver.setNotificationAlarm(getApplicationContext(), 1000 * 60);
                }
                else {
                    timeIncrementSpinner.setEnabled(false);
                    AlarmReceiver.disableNotificationAlarm(getApplicationContext());
                }
            }
        });

        timeIncrementSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!AlarmReceiver.hasNotificationAlarm(getApplicationContext())){
                    AlarmReceiver.disableNotificationAlarm(getApplicationContext());
                }
                CharSequence selection = (CharSequence) parent.getItemAtPosition(position);

                long interval;
                long minute = 1000 * 60;
                long hour = minute * 60;

                if (selection.equals("Minute")){
                    interval = minute;
                }
                else if(selection.equals("Half hour")){
//                    interval = minute * 30;
                    interval = AlarmManager.INTERVAL_HALF_HOUR;
                }
                else if(selection.equals("Hourly")){
//                    interval = hour;
                    interval = AlarmManager.INTERVAL_HOUR;
                }
                else if(selection.equals("Daily")){
//                    interval = hour * 24;
                    interval = AlarmManager.INTERVAL_DAY;
                }
                else if(selection.equals("Weekly")){
                    interval = hour * 24 * 7;
                }
                else if(selection.equals("Biweekly")){
                    interval = hour * 24 * 7 * 2;
                }
                else{
                    interval = hour * 24 * 7 * 4;
                }

                AlarmReceiver.setNotificationAlarm(getApplicationContext(), interval);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
