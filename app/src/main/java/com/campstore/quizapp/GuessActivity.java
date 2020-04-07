package com.campstore.quizapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GuessActivity extends AppCompatActivity {
private EditText guessTextInput;
private Button guessButton;
private final int REQUEST_CODE = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        guessTextInput = findViewById(R.id.guess_text_input);
        guessButton = findViewById(R.id.guess_button);


        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String guessText = guessTextInput.getText().toString().trim();
                if(!guessText.isEmpty()) {
                    Intent intent = new Intent(GuessActivity.this, GuessResult.class);
                    intent.putExtra("name", guessText);
                    startActivityForResult(intent, REQUEST_CODE);
                }else {
                    Toast.makeText(GuessActivity.this, "Your Guess input is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            String message = data.getStringExtra("message");

            Toast.makeText(GuessActivity.this, message, Toast.LENGTH_SHORT).show();;

        }


    }
}
