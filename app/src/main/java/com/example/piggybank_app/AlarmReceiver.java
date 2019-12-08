package com.example.piggybank_app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import static android.content.Context.ALARM_SERVICE;

public class AlarmReceiver extends BroadcastReceiver {

    String TAG = "AlarmReceiver";
    private String CHANNEL_ID = "PiggyBank";

    //picked random number, hope it doesn't conflict with anything
    private static int NOTIFICATION_CODE = 672;



    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("alarm received", "first alarm check");

        Intent i = new Intent(context, NotificationIntentService.class);
        context.startService(i);

        Log.d(TAG, "onReceive: ");

        //Trigger notification
    }

    public static boolean hasNotificationAlarm(Context context){
        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent= PendingIntent.getBroadcast(context, NOTIFICATION_CODE, intent, PendingIntent.FLAG_NO_CREATE);
        return pendingIntent != null;
    }

    public static void setNotificationAlarm(Context context, long timeInterval){
        AlarmManager alarmManager;

        Intent intent1 = new Intent(context, AlarmReceiver.class);
        //small increments for testing purposes
        long minute = 1000 * 60;
        long hour = minute * 60;
        long delay = minute;
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, NOTIFICATION_CODE, intent1, 0);
        alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + timeInterval, timeInterval, pendingIntent);

    }

    public static void disableNotificationAlarm(Context context){
        Intent intent1 = new Intent(context, AlarmReceiver.class);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, NOTIFICATION_CODE, intent1, 0);
        alarmManager.cancel(pendingIntent);
    }
}
