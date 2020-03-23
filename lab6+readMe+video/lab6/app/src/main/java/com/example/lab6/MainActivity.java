package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    MySharedPreference mySharedPreference;

    Button btnSave;
    Button btnGo;
    EditText myData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySharedPreference = new MySharedPreference(MainActivity.this);

        btnSave = findViewById(R.id.btnSave);
        btnGo = findViewById(R.id.btnGo);
        myData = findViewById(R.id.myData);

        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String pref = myData.getText().toString();
                mySharedPreference.save(pref);
            }
        });
    }


    public void openActivity2(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("name", "Something random I wanted to pass in the second activity");
        startActivity(intent);
    }
}
