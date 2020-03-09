package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FindTheNumberActivity extends AppCompatActivity {

    private static final String TAG =MainActivity.class.getSimpleName();
    public static final int MAX_NUMBER= 10;
    public static final Random RANDOM = new Random();
    private TextView showMsg;
    private TextView textSus;
    private EditText number;
    private Button guessBtn;

    private int nrDorit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_the_number);


        showMsg=(TextView) findViewById(R.id.showMsg);
        textSus=(TextView) findViewById(R.id.textView);
        number= (EditText) findViewById(R.id.editText);
        guessBtn= (Button) findViewById(R.id.guessBtn);


        newGame();
    }


    public void guessNr(View view) {
        int n= Integer.parseInt(number.getText().toString());


        if(n==nrDorit){
            newGame();
        }
        else if( n> nrDorit){
            showMsg.setText("Lower! Try again");
        }
        else if( n< nrDorit){
            showMsg.setText("Higher! Try again");
        }
    }

    private void newGame(){
        nrDorit = RANDOM.nextInt(MAX_NUMBER) +1;
        textSus.setText("YOU WON! You can start a new game now");
        showMsg.setText("");
        number.setText("");
    }
}
