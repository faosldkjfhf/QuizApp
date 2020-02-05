package com.liukevin.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button submitButton;
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
        responseText2=findViewById(R.id.response2EditText);
        displayText=findViewById(R.id.textBox);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("testButton", "Hi dad! " + responseText.getText());
                count += 1;
                displayText.setText(getString(R.string.string) + count);
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
