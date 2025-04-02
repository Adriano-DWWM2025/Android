package com.example.myimc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalculIMCActivity extends AppCompatActivity {

    private EditText etPoids, etTaille;
    private Button btnCalculer;
    private ImageButton btnRetour;
    private TextView tvResultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affichage_calcul_imc_activity);


        etPoids = findViewById(R.id.poids);
        etTaille = findViewById(R.id.taille);
        btnCalculer = findViewById(R.id.btn_calculer);
        tvResultat = findViewById(R.id.tv_resultat);
        btnRetour = findViewById(R.id.btnRetour);


        btnCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculerIMC();
            }
        });


        btnRetour.setOnClickListener(view -> {

            Intent retourIntent = new Intent(CalculIMCActivity.this, Activity2.class);
            startActivity(retourIntent);
            finish();
        });
    }

    private void calculerIMC() {
        String poidsStr = etPoids.getText().toString();
        String tailleStr = etTaille.getText().toString();

        if (poidsStr.isEmpty() || tailleStr.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs.", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            float poids = Float.parseFloat(poidsStr);
            float taille = Float.parseFloat(tailleStr);

            if (poids < 40 || poids > 250) {
                Toast.makeText(this, "Le poids doit être entre 40 kg et 250 kg.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (taille < 100 || taille > 250) {
                Toast.makeText(this, "La taille doit être entre 100 cm et 250 cm.", Toast.LENGTH_SHORT).show();
                return;
            }


            taille = taille / 100;
            float imc = poids / (taille * taille);


            String categorie;
            if (imc < 19) {
                categorie = "Maigreur";
            } else if (imc >= 19 && imc < 25) {
                categorie = "Corpulence normale";
            } else if (imc >= 25 && imc < 30) {
                categorie = "Surpoids";
            } else if (imc >= 30 && imc < 35) {
                categorie = "Obésité modérée";
            } else if (imc >= 35 && imc <= 40) {
                categorie = "Obésité sévère";
            } else { // IMC > 40
                categorie = "Obésité morbide";
            }


            SQLiteIMCDataBase dbHelper = new SQLiteIMCDataBase(this);
            String date = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
            dbHelper.insertionIMC(poids, taille * 100, imc, date);


            Intent intent = new Intent(CalculIMCActivity.this, IMCResultActivity.class);
            intent.putExtra("imcValue", imc);
            intent.putExtra("imcCategory", categorie);
            startActivity(intent);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Veuillez entrer des valeurs numériques valides.", Toast.LENGTH_SHORT).show();
        }
    }
}
