package com.example.piggybank_app;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class profileActivity extends AppCompatActivity {

    TextView spending, username;
    ImageView profile_picture;
    RecyclerView recent_transactions;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Finding necessary elements
        username = (TextView) findViewById(R.id.username);
        spending = (TextView) findViewById(R.id.total_spent_view);
        profile_picture = (ImageView) findViewById(R.id.profile_picture);
        recent_transactions = (RecyclerView) findViewById(R.id.recent_transactions_view);
        back = (Button) findViewById(R.id.back_profile);

    }

    private void setUsername(String str){
        //should probably moved into onCreate once the app is further along
        username.setText(str);
    }



}
