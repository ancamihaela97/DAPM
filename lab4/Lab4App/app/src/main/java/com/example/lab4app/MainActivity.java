package com.example.lab4app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button loginBtn;
    EditText username;
    EditText password;
    private static final String TAG =MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn =(Button) findViewById(R.id.loginBtn);
        username = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.pass);


        System.out.println("TAG =" + TAG);

        Log.d(TAG, "DEBUG");
        Log.i(TAG, "INFO");
        Log.w(TAG, "WARNING");
        Log.e(TAG, "ERROR");

        if (savedInstanceState !=null){
            Log.d(TAG, "onCreate()");
        }
    }

    public void login(View view) {
        String uname= username.getText().toString();
        String pass= password.getText().toString();

        if(uname.equals("student")&& pass.equals("student")){
            openActivity2();
        }
    }


    public void openActivity2(){
        Intent intent = new Intent(this, DoggoVsCatto.class);
        startActivity(intent);
    }





}
