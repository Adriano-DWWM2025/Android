package com.example.myimc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affichage_activity2);


        ImageView imgCalculIMC = findViewById(R.id.img_calcul_imc);
        ImageView imgVoirResultats = findViewById(R.id.img_voir_resultats);
        ImageView imgActivitesSportives = findViewById(R.id.img_activites_sportives);


        imgCalculIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Activity2.this, CalculIMCActivity.class);
                startActivity(intent);
            }
        });

        imgVoirResultats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Activity2.this, IMCDataBaseActivity.class);
                startActivity(intent);
            }
        });

        imgActivitesSportives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Activity2.this, SportActivitiesActivity.class);
                startActivity(intent);
            }
        });
    }
}
