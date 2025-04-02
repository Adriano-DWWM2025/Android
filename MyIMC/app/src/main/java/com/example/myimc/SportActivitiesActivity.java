package com.example.myimc;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SportActivitiesActivity extends AppCompatActivity {

    private SQLiteIMCDataBase dbHelper;
    private EditText etNomSport, etDuree;
    private ListView lvActivites;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> activitesList;
    private ImageButton btnRetour;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affichage_sport_activities_activity);


        etNomSport = findViewById(R.id.et_nom_sport);
        etDuree = findViewById(R.id.et_duree);
        lvActivites = findViewById(R.id.lv_activites);
        Button btnAjouterActivite = findViewById(R.id.btn_ajouter_activite);
        btnRetour = findViewById(R.id.btnRetour);
        searchView = findViewById(R.id.search_view);

        dbHelper = new SQLiteIMCDataBase(this);
        activitesList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, activitesList);
        lvActivites.setAdapter(adapter);

        loadActivities();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterActivities(newText);
                return true;
            }
        });


        btnAjouterActivite.setOnClickListener(v -> {
            String nom = etNomSport.getText().toString();
            String dureeStr = etDuree.getText().toString();

            if (nom.isEmpty() || dureeStr.isEmpty()) {
                Toast.makeText(SportActivitiesActivity.this, "Veuillez remplir tous les champs.", Toast.LENGTH_SHORT).show();
            } else {
                try {
                    int duree = Integer.parseInt(dureeStr);
                    dbHelper.insertionActivite(nom, duree);
                    Toast.makeText(SportActivitiesActivity.this, "Activité ajoutée !", Toast.LENGTH_SHORT).show();

                    etNomSport.setText("");
                    etDuree.setText("");
                    loadActivities();
                } catch (NumberFormatException e) {
                    Toast.makeText(SportActivitiesActivity.this, "La durée doit être un nombre valide.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnRetour.setOnClickListener(v -> {
            Intent retourIntent = new Intent(SportActivitiesActivity.this, Activity2.class);
            startActivity(retourIntent);
            finish();
        });
    }

    private void loadActivities() {
        activitesList.clear();
        Cursor cursor = dbHelper.lireToutesLesActivites();

        if (cursor.getCount() == 0) {
            activitesList.add("Aucune activité enregistrée.");
        } else {
            while (cursor.moveToNext()) {
                String nom = cursor.getString(1);
                int duree = cursor.getInt(2);
                activitesList.add(nom + " - " + duree + " minutes");
            }
        }

        cursor.close();
        adapter.notifyDataSetChanged();
    }

    private void filterActivities(String query) {
        ArrayList<String> filteredList = new ArrayList<>();

        if (query.isEmpty()) {
            filteredList.addAll(activitesList);
        } else {

            for (String activity : activitesList) {
                if (activity.toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(activity);
                }
            }
        }

        adapter.clear();
        adapter.addAll(filteredList);
        adapter.notifyDataSetChanged();
    }

}


