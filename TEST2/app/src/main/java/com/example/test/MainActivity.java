package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button btn;
    //private EditText monEditText;
    private EditText monEditNum;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        //monEditText = findViewById(R.id.editTextText2);
        monEditNum = findViewById(R.id.editTextNumber);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String strName = monEditText.getText().toString();
                String monString = monEditNum.getText().toString().trim();

                if (monString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Le champ ne peut pas être vide", Toast.LENGTH_LONG).show();
                    return;
                }
                int intName = Integer.valueOf(monString);

                Log.i("monEditNum", String.valueOf(intName));
                monEditNum.setText("");

            }
        });

    }
}