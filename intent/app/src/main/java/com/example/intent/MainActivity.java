package com.example.intent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView2;
    private EditText editText;
    private Button button1;
    private final static int idMainActivity2 = 42;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView2 = findViewById(R.id.textView2);
        button1 = findViewById(R.id.button1);
        editText = findViewById(R.id.editText);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String envoyerData = editText.getText().toString().trim();
                if (envoyerData.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Veuillez écrire un message", Toast.LENGTH_SHORT).show();

                } else {

                    Intent monIntent = new Intent(getApplicationContext(), MainActivity2.class);
                    monIntent.putExtra("dataSend", envoyerData);
                    startActivityForResult(monIntent, idMainActivity2);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == idMainActivity2) {
            String recup_dataReSend = (String) data.getSerializableExtra("dataReSend");


            textView2.setText(recup_dataReSend);
        }
    }

}