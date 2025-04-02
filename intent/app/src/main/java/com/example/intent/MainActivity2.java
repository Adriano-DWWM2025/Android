package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private TextView textView;
    private EditText etReponse;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        etReponse = findViewById(R.id.etReponse);


        String recup = (String) getIntent().getSerializableExtra("dataSend");
        textView.setText(recup);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rep = etReponse.getText().toString().trim();
                if (rep.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Veuillez écrire un message", Toast.LENGTH_SHORT).show();

                } else {

                    Intent iMa2 = new Intent();
                    iMa2.putExtra("dataReSend", rep);

                    setResult(RESULT_OK, iMa2);
                    finish();
                }
            }
        });
    }
}