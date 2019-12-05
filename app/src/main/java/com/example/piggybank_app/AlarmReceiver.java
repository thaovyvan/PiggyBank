package com.example.piggybank_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

public class AlarmReceiver extends BroadcastReceiver {

    String TAG = "AlarmReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && context != null){

        }
    }

    public static void setReminder(Context context, Class<?> cls, int hour, int min){
        Calendar calendar = Calendar.getInstance();
        Calendar setCalandar = Calendar.getInstance();
        
    }
}
