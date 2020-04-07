package com.campstore.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GuessResult extends AppCompatActivity {
private TextView guessText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_result);
        Bundle extra = getIntent().getExtras();

        guessText = findViewById(R.id.guess_text);

     //   if(extra != null)
            guessText.setText(getIntent().getStringExtra("name"));


            guessText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = getIntent();
                    intent.putExtra("message", "From the Guess screen");
                    setResult(RESULT_OK, intent);
                   finish();

                }
            });

    }
}
