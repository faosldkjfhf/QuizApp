package com.liukevin.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button submitButton;
    Button submitButton2;
    EditText responseText;
    EditText responseText2;
    TextView displayText;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton=findViewById(R.id.clickButton);
        responseText=findViewById(R.id.responseEditText);
        displayText=findViewById(R.id.textBox);
        submitButton2=findViewById(R.id.clickButton2);
        responseText2=findViewById(R.id.response2EditText);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("testButton", "Hi dad! " + responseText.getText());
                count += 1;
                displayText.setText(getString(R.string.string) + count);
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                v.setBackgroundColor(color);
            }
        });
        submitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                v.setBackgroundColor(color);
            }
        });
        responseText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    if(responseText.getText().toString().equals(getString(R.string.focusChangeText))) {
                        displayText.setText(R.string.displayTextFocusChange);
                        responseText.setText("");
                        responseText.setHint(R.string.responseHint);
                    }
                }
            }
        });
    }
}
