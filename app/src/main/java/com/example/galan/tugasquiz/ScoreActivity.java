package com.example.galan.tugasquiz;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private TextView mScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        mScores = (TextView) findViewById(R.id.scoreare);

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("result", 0);
        mScores.setText(String.valueOf(intValue));


    }
}
