package com.example.notepad;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText saisieCouleurFond, saisieCouleurTexte;
    private Button btnValiderFond, btnValiderTexte;
    private TextView zoneTexte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saisieCouleurFond = findViewById(R.id.saisieCouleurFond);
        saisieCouleurTexte = findViewById(R.id.saisieCouleurTexte);
        btnValiderFond = findViewById(R.id.btnValiderFond);
        btnValiderTexte = findViewById(R.id.btnValiderTexte);
        zoneTexte = findViewById(R.id.zoneTexte);

        btnValiderFond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colorFond = saisieCouleurFond.getText().toString().trim();
                try {
                    zoneTexte.setBackgroundColor(Color.parseColor(colorFond));
                } catch (IllegalArgumentException e) {
                    saisieCouleurFond.setError("Couleur invalide");
                }
            }
        });

        btnValiderTexte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colorTexte = saisieCouleurTexte.getText().toString().trim();
                try {
                    zoneTexte.setTextColor(Color.parseColor(colorTexte));
                } catch (IllegalArgumentException e) {
                    saisieCouleurTexte.setError("Couleur invalide");
                }
            }
        });

    }
}
