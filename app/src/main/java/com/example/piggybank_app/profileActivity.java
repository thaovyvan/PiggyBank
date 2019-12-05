package com.example.piggybank_app;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.stripe.android.CustomerSession;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.Stripe;
import com.stripe.android.model.Customer;

public class profileActivity extends AppCompatActivity {

    TextView spending, username;
    ImageView profile_picture;
    RecyclerView recent_transactions;
    Button back;
    Stripe stripe = new Stripe(this, "pk_test_UVYfBYe81Mtx9O192lqNO1IW00EAI3P22t");


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

        PaymentConfiguration.init(getApplicationContext(), "pk_test_UVYfBYe81Mtx9O192lqNO1IW00EAI3P22t");

    }

    private void setUsername(String str){
        //should probably moved into onCreate once the app is further along
        username.setText(str);
    }

    private void getTransactionHistory(){
    }



}
