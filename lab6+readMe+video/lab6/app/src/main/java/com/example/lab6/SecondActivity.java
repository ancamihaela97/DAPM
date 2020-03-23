package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    MySharedPreference mySharedPref;
    TextView outputData;
    TextView extra;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        outputData = findViewById(R.id.outputData);
        extra = findViewById(R.id.extra);
        mySharedPref = new MySharedPreference(this);
        String output = mySharedPref.getValue();
        outputData.setText(output);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        extra.setText(name);
    }
}
