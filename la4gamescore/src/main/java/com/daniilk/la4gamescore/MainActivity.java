package com.daniilk.la4gamescore;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private int score1 = 0;
    private int score2 = 0;

    private TextView textViewScope1;
    private TextView textViewScope2;

    // Самостоятельно вызвать log debug для onCreate, onSaveInstanceState и onDestroy

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // при создании / запуске Activity
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);

        textViewScope1 = findViewById(R.id.textViewScope1);
        textViewScope2 = findViewById(R.id.textViewScope2);

        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt("score1");
            score2 = savedInstanceState.getInt("score2");
        }

        updateScore1();
        updateScore2();

        textViewScope1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                Log.d(TAG, "onClick: textViewScore1");
                score1++;
                updateScore1();
            }
        });

        textViewScope2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: textViewScore2");
                score2++;
                updateScore2();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    private void updateScore1() {
        textViewScope1.setText(String.valueOf(score1));
    }

    private void updateScore2() {
        textViewScope2.setText(String.valueOf(score2));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
        outState.putInt("score1", score1);
        outState.putInt("score2", score2);
    }


    @Override
    protected void onDestroy() { // при уничтожении Activity
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}