package com.example.monsqlite;

import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SQLiteMaDataBase maSQLdb;
    private RecyclerView recyclerView;
    private AdaptaterClients adaptaterClients;
    private List<Clients> mesClients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.monRecyclerView);
        mesClients = new ArrayList<>();
        maSQLdb = new SQLiteMaDataBase(this);

        chargerLesClientsDepuisBD();

        adaptaterClients = new AdaptaterClients(mesClients, this);

        int orientation = getResources().getConfiguration().orientation;

        if (Configuration.ORIENTATION_LANDSCAPE == orientation) {

            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
        } else
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        recyclerView.setAdapter(adaptaterClients);
        recyclerView.setAdapter(adaptaterClients);

        private void chargerLesClientsDepuisBD() {
            Cursor cursor = maSQLdb.lireTable();


            if (cursor.getCount() == 0) {
                Toast.makeText(this, "Aucune donnée trouvée.", Toast.LENGTH_SHORT).show();
            } else {
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(cursor.getColumnIndexOrThrow("IdClient"));
                    String nom = cursor.getString(cursor.getColumnIndexOrThrow("NOM"));
                    String prenom = cursor.getString(cursor.getColumnIndexOrThrow("PRENOM"));
                    int age = cursor.getInt(cursor.getColumnIndexOrThrow("AGE"));

                    mesClients.add(new Clients(nom, prenom, age));
                }
            }
            cursor.close();
        }
    }

//        EffetSwipe effetSwipe = new EffetSwipe(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, MainActivity.this, mesClients, adaptaterClients);
//        new ItemTouchHelper(effetSwipe).attachToRecyclerView(recyclerView);
//
    }

}

