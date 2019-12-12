package com.example.piggybank_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

public class welcomeActivity extends AppCompatActivity {
    public static String welcomeBackName;
    TextView welcomeBackText;

    private AlarmManager alarmManager;
    private PendingIntent alarmIntent;

    private String CHANNEL_ID = "PiggyBank";

    JSONObject object;
    JSONObject getObject;
    JSONArray getArray;

    ArrayList<String> transactions;

    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcomeBackText = (TextView)findViewById(R.id.welcome_textView);
        Intent intent = getIntent();
        welcomeBackName = intent.getStringExtra("username");
        welcomeBackText.setText("Welcome back " + welcomeBackName);

        try {
            object = new JSONObject("transactions_json.json");
            getObject = object.getJSONObject("Transactions");
            getArray = getObject.getJSONArray("TransactionsArray");

            transactions = getTransactions(getArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.welcomeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, transactions);
        recyclerView.setAdapter(adapter);


    }

    public void goToSettings(View view) {
        Intent intent = new Intent(this, settingsActivity.class);
        startActivity(intent);
    }

    public static ArrayList<String> getTransactions(JSONArray jsonArray) throws JSONException {

        ArrayList<String> returnList = new ArrayList<String>();
        for (int i=0; i<jsonArray.length(); i++) {
            JSONObject currObject = jsonArray.getJSONObject(i);
            String transactionName = currObject.getString("name");
            String transactionCost = currObject.getString("cost");

            String finalString = String.format("%s, %s", transactionName, transactionCost);
            returnList.add(finalString);
        }

        return returnList;
    }
}
