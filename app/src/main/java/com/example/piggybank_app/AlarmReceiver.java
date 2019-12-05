package com.example.piggybank_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {

    String TAG = "AlarmReceiver";
    private String CHANNEL_ID = "PiggyBank";

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("alarm received", "first alarm check");

        Intent i = new Intent(context, NotificationIntentService.class);
        context.startService(i);

        Log.d(TAG, "onReceive: ");

        //Trigger notification
    }
}
