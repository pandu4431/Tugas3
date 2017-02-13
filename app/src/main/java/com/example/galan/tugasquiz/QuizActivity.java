package com.example.galan.tugasquiz;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private QuestionLibrery mQuestionLibrary = new QuestionLibrery();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoices1;
    private EditText sAnswer;
    private Button mNext;
    private Button mPrev;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestinNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoices1 = (Button) findViewById(R.id.submit);
        sAnswer = (EditText) findViewById(R.id.jawaban);
        mNext = (Button) findViewById(R.id.next);
        mPrev = (Button) findViewById(R.id.back);
        updateQuestion();

        mNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mQuestinNumber++;
                mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestinNumber));
                mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestinNumber);
            }
        });

        mPrev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mQuestinNumber--;
                mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestinNumber));
                mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestinNumber);
            }
        });

        //Button1
        mButtonChoices1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String xs = sAnswer.getText().toString();

                if (xs.equals(mAnswer)){
                    mScore = mScore + 10;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(QuizActivity.this, "CORRECT ANSWER, GOOD", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(QuizActivity.this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void updateQuestion(){
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestinNumber));
        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestinNumber);
        if (mQuestinNumber !=4) {
            mQuestinNumber++;
        }else {
            Toast.makeText(QuizActivity.this, "SELAMAT, SUDAH SELESAI, POIN ANDA", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builders = new AlertDialog.Builder(QuizActivity.this);
            builders.setMessage("Apakah Anda Ingin Mengulanginya ?");
            builders.setCancelable(true);
            builders.setPositiveButton("IYA", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    mQuestinNumber = 0;
                }
            });
            builders.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    finish();
                }
            });
            AlertDialog alert = builders.create();
            alert.show();
        }
    }

    private void updateScore(int point){
        mScoreView.setText(""+mScore);
    }

    public void clickExit(View v){
        finish();
    }

    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(QuizActivity.this);
        builder.setMessage("Apakah Anda Yakin Ingin Keluar");
        builder.setCancelable(true);
        builder.setPositiveButton("IYA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
