package com.example.android.quidditch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreGryffindor = 0;
    int scoreRavenclaw = 0;

    static final String gryff_score = "gryff_score";
    static final String ravenclaw_score = "ravenclaw_score";

    @Override

    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(gryff_score, scoreGryffindor);
        savedInstanceState.putInt(ravenclaw_score, scoreRavenclaw);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            // Restore value of members from saved state
            scoreGryffindor = savedInstanceState.getInt(gryff_score);
            scoreRavenclaw = savedInstanceState.getInt(ravenclaw_score);
        }
        displayForRavenclaw(scoreRavenclaw);
        displayForGryffindor(scoreGryffindor);
    }

    //Gryffindor score, display
    public void displayForGryffindor(int score) {
        TextView scoreView = (TextView) findViewById(R.id.g_score);
        scoreView.setText(String.valueOf(score));
    }

    //Ravenclaw score, display
    public void displayForRavenclaw(int score) {
        TextView scoreView = (TextView) findViewById(R.id.r_score);
        scoreView.setText(String.valueOf(score));
    }

    //display result message
    public void displayResult(String message) {
        TextView scoreView = (TextView) findViewById(R.id.result);
        scoreView.setText(String.valueOf(message));
    }

    //add scores to Gryffindor
    public void addTenToGryffindor(View view) {
        scoreGryffindor += 10;
        displayForGryffindor(scoreGryffindor);
    }

    //add scores to Gryffindor
    public void addSnitchToGryffindor(View view) {
        scoreGryffindor += 150;
        displayForGryffindor(scoreGryffindor);
        result(scoreGryffindor, scoreRavenclaw);
    }

    //add score to Ravenclaw
    public void addTenToRaveclaw(View view) {
        scoreRavenclaw += 10;
        displayForRavenclaw(scoreRavenclaw);
    }

    //add score to Ravenclaw
    public void addSnitchToRavenclaw(View view) {
        scoreRavenclaw += 150;
        displayForRavenclaw(scoreRavenclaw);
        result(scoreGryffindor, scoreRavenclaw);
    }

    //start a new game
    public void reset(View view) {
        scoreRavenclaw = 0;
        displayForRavenclaw(scoreRavenclaw);
        scoreGryffindor = 0;
        displayForGryffindor(scoreGryffindor);
        displayResult("The game is not over");
    }

    //end game
    public void result(int res1, int res2) {
        if (res1 >= res2) {
            displayResult("Gryffindor wins!");
        } else {
            displayResult("Ravenclaw wins!");
        }
    }
}

