package com.example.mcqapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView t1, t2, t3;
    int total, correct, wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t1 = (TextView) findViewById(R.id.totalTxt);
        t2 = (TextView) findViewById(R.id.correctTxt);
        t3 = (TextView) findViewById(R.id.wrongTxt);

        Intent i = getIntent();

        String questions = i.getStringExtra("total");
        String correct = i.getStringExtra("correct");
        String wrong = i.getStringExtra("wrong");

        t1.setText(questions);
        t2.setText(correct);
        t3.setText(wrong);
    }

}