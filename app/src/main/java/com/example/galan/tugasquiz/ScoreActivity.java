package com.example.galan.tugasquiz;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private TextView mScores;
    private Button mBacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        mScores = (TextView) findViewById(R.id.scoreare);
        mBacks = (Button) findViewById(R.id.backtomain);

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("result", 0);
        mScores.setText(String.valueOf(intValue));

        mBacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
