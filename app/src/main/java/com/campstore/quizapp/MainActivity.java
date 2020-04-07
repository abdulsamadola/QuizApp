package com.campstore.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView questionTextView;

    private Button  trueButton;
    private  Button falseButton;
    private ImageButton nextButton;
    private ImageButton prevButton;
    private int initialQuestion = 0;

    Question[] questions = new Question[]{
            new Question(R.string.q1, true),
            new Question(R.string.q2, false),
            new Question(R.string.q3, true),
            new Question(R.string.q4, false),
            new Question(R.string.q5, false),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.question_text_view);
        trueButton =  findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        prevButton = findViewById(R.id.prev_button);


        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);

        questionTextView.setText(questions[initialQuestion].getQuestion());

        if(initialQuestion == 0){
                    prevButton.setVisibility(View.INVISIBLE);

        }else {
            prevButton.setVisibility(View.VISIBLE);

        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.true_button:
                if(questions[initialQuestion].getAnswer()) {
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, R.string.wrong, Toast.LENGTH_SHORT).show();

                }
                if(initialQuestion <= questions.length - 1) {
                    questionTextView.setText(questions[initialQuestion++].getQuestion());
                }else {
                    initialQuestion = 0;
                    questionTextView.setText(questions[initialQuestion].getQuestion());
                    prevButton.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.false_button:
                if(!questions[initialQuestion].getAnswer()) {
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, R.string.wrong, Toast.LENGTH_SHORT).show();

                }
                if(initialQuestion <= questions.length -1) {
                    questionTextView.setText(questions[initialQuestion++].getQuestion());
                }else {
                    initialQuestion = 0;
                    questionTextView.setText(questions[initialQuestion].getQuestion());
                    prevButton.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.next_button:
                initialQuestion++;
                if(initialQuestion <= questions.length-1) {
                     questionTextView.setText(questions[initialQuestion].getQuestion());
                    prevButton.setVisibility(View.VISIBLE);

                }else {
                initialQuestion = 0;
                    questionTextView.setText(questions[initialQuestion].getQuestion());
                   prevButton.setVisibility(View.INVISIBLE);
                }
                break;
            case  R.id.prev_button:
                initialQuestion--;
                if(!(initialQuestion < 0)) {
                    questionTextView.setText(questions[initialQuestion].getQuestion());
                }else {
                    initialQuestion = 0;
                }


        }

    }
}
