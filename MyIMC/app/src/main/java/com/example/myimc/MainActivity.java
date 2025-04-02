package com.example.myimc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Utilisation du Handler pour lancer une autre activité avec un délai
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);
                finish(); // Termine l'activité actuelle
            }
        }, 2000); // Temps d'attente en millisecondes (2000ms = 2 secondes)
    }
}
