package com.example.piggybank_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class summaryActivity extends AppCompatActivity {
    private TextView monthlySpending;
    private TextView firstPercentage, secondPercentage, thirdPercentage;
    private TextView firstPercent, secondPercent, thirdPercent;

    JSONArray getArray;
    String jsonString;
    ArrayList<String> transactions;
    HashMap<String, Float> percentages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        monthlySpending = findViewById(R.id.monthlySpending);
        firstPercentage = findViewById(R.id.socialMediaPercentage);
        secondPercentage = findViewById(R.id.photoPercentage);
        thirdPercentage = findViewById(R.id.gamesPercentage);

        firstPercent = findViewById(R.id.firstPercentLabel);
        secondPercent = findViewById(R.id.secondPercentLabel);
        thirdPercent = findViewById(R.id.thirdPercentLabel);

        jsonString = loadJSONFromAsset();
        try {
            getArray = new JSONArray(jsonString);
            String tempMonthly = get_monthly(getArray);
            monthlySpending.setText(tempMonthly);

            percentages = get_percentages(getArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        float max = Collections.max(percentages.values());
        float percentTemp = max*100;
        ArrayList<String> tempSet = new ArrayList<String>(percentages.keySet());
        for (int i=0; i<tempSet.size(); i++) {
            String key = tempSet.get(i);
            if (percentages.get(key) == max) {
                percentTemp = (int) percentTemp;
                firstPercentage.setText(percentTemp + "%");
                firstPercent.setText(key);
                percentages.remove(key);
            }
        }

        System.out.println(percentages.values());

        max = Collections.max(percentages.values());
        percentTemp = max*100;
        tempSet = new ArrayList<String>(percentages.keySet());
        for (int i=0; i<tempSet.size(); i++) {
            String key = tempSet.get(i);
            if (percentages.get(key) == max) {
                percentTemp = (int) percentTemp;
                secondPercentage.setText(percentTemp + "%");
                secondPercent.setText(key);
                percentages.remove(key);
            }
        }

        max = Collections.max(percentages.values());
        percentTemp = max*100;
        tempSet = new ArrayList<String>(percentages.keySet());
        for (int i=0; i<tempSet.size(); i++) {
            String key = tempSet.get(i);
            if (percentages.get(key) == max) {
                percentTemp = (int) percentTemp;
                thirdPercentage.setText(percentTemp + "%");
                thirdPercent.setText(key);
            }
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getApplicationContext().getAssets().open("transactions-json.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public String get_monthly(JSONArray array) throws JSONException {
        float totalValue = 0;
        for (int i=0; i<array.length(); i++) {
            JSONObject currObject = array.getJSONObject(i);
            String date = currObject.getString("date");
            if (date.startsWith("12")) {
                String transactionCost = currObject.getString("cost");
                float actual_moniez = Float.parseFloat(transactionCost.substring(1));
                totalValue += actual_moniez;
            }
        }
        String returnString = "$" + totalValue;
        return returnString;
    }

    public HashMap<String, Float> get_percentages(JSONArray array) throws JSONException {
        float total = array.length()-1;
        HashMap<String, Float> returnMap = new HashMap<String, Float>();
        HashMap<String, Integer> frequencyTransactions = new HashMap<String, Integer>();
        ArrayList<String> types = new ArrayList<String>();
        for (int i=0; i<array.length(); i++) {
            JSONObject currObject = array.getJSONObject(i);
            String type = currObject.getString("type");
            if (frequencyTransactions.containsKey(type)) {
                Integer val = frequencyTransactions.get(type);
                frequencyTransactions.put(type, val + 1);
            }
            else {
                frequencyTransactions.put(type, 1);
                types.add(type);
            }
        }
        for (int i=0; i<3; i++) {
            int max = Collections.max(frequencyTransactions.values());
            for (int j=0; j<types.size(); j++) {
                String key = types.get(j);
                if (frequencyTransactions.get(key) == max) {
                    returnMap.put(key, max/total);
                    frequencyTransactions.remove(key);
                    types.remove(key);
                }
            }
        }
        System.out.println("PEACHES AND MANGO" + returnMap);
        return returnMap;
    }
}
