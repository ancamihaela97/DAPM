package com.example.lab4app;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DoggoVsCatto extends AppCompatActivity {
    // 0 = x, 1 = o
    int activePlayer = 0;
    boolean gameIsActive = true;
    // 2 unplayed
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    private TextView displayMsg;
    LinearLayout linearLayout ;
    GridLayout gridLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doggo_vs_catto);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        gridLayout =(GridLayout) findViewById(R.id.gridLayout);
    }


    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        // get the current Image View (counter tag)
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        displayMsg=(TextView) findViewById(R.id.displayMsg);

        //if the space is empty(is 2) and the game is not over
        if (gameState[tappedCounter] == 2 && gameIsActive) {
            //set the current player
            gameState[tappedCounter] = activePlayer;
            if (activePlayer == 0) {
                // setImageResource for counter as x
                counter.setImageResource(R.drawable.doggo);
                // change the player's turn
                activePlayer = 1;
            } else {
                // setImageResource for counter as zero
                counter.setImageResource(R.drawable.catto);
                activePlayer = 0;
            }
            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {
                    // Someone has won!
                    gameIsActive = false;
                    String winner = " CATTO";

                    if (gameState[winningPosition[0]] == 0) {
                        winner = " DOGGO";
                    }
                    // Make a toast with the messaje winner + " has won!"
                    //  Toast.makeText(this, winner+ " has won!", Toast.LENGTH_SHORT).show();
                    linearLayout.setVisibility(View.VISIBLE);
                    displayMsg.setText(winner+" has won!");

                    final MediaPlayer applause = MediaPlayer.create(this, R.raw.applause);
                    applause.start();

                } else {
                    boolean gameIsOver = true;

                    for (int counterState : gameState) {
                        if (counterState == 2)
                            gameIsOver = false;
                    }
                    if (gameIsOver) {
                        // Make a toast with the messaje "It's a draw!"
                        // Toast.makeText(this,  " It's a draw!", Toast.LENGTH_SHORT).show();
                        linearLayout.setVisibility(View.VISIBLE);
                        displayMsg.setText(" It's a draw!");
                    }
                }
            }
        }
    }

    public void playAgain(View view){
        displayMsg.setText("");
        linearLayout.setVisibility(View.INVISIBLE);
        activePlayer = 0;
        gameIsActive = true;


        for(int j =0; j< gameState.length; j++){
            gameState[j]= 2;
        }

        for (int i = 0; i< gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }

    }
}
