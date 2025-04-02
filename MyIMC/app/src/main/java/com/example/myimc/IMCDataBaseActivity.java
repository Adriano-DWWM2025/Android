package com.example.myimc;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IMCDataBaseActivity extends AppCompatActivity {

    private SQLiteIMCDataBase dbHelper;
    private ListView lvHistorique;
    private ImageButton btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affichage_imc_database_activity);

        lvHistorique = findViewById(R.id.lv_historique);
        btnRetour = findViewById(R.id.btnRetour);


        dbHelper = new SQLiteIMCDataBase(this);

        afficherHistorique();

        btnRetour.setOnClickListener(v -> {
            Intent retourIntent = new Intent(IMCDataBaseActivity.this, Activity2.class);
            startActivity(retourIntent);
            finish();
        });
    }

    private void afficherHistorique() {
        Cursor cursor = dbHelper.lireTableIMC();

        ArrayList<Map<String, String>> data = new ArrayList<>();
        while (cursor.moveToNext()) {
            Map<String, String> entry = new HashMap<>();
            entry.put("poids", "Poids : " + cursor.getFloat(1) + " kg");
            entry.put("taille", "Taille : " + cursor.getFloat(2) + " cm");
            entry.put("imc", "IMC : " + String.format("%.2f", cursor.getFloat(3)));
            entry.put("date", "Date : " + cursor.getString(4));
            data.add(entry);
        }
        cursor.close();


        SimpleAdapter adapter = new SimpleAdapter(
                this,
                data,
                android.R.layout.simple_list_item_2,
                new String[]{"imc", "date"},
                new int[]{android.R.id.text1, android.R.id.text2}
        );
        lvHistorique.setAdapter(adapter);
    }
}
