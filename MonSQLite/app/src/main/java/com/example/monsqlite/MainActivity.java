package com.example.monsqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText editTextRecherche;
    private SQLiteMaDataBase maSQLdb;
    private ListView maListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextRecherche = findViewById(R.id.editTextRecherche);
        maListView = findViewById(R.id.maListView);
        maSQLdb = new SQLiteMaDataBase(this);

        editTextRecherche.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                rechercherDansBase(s.toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void rechercherDansBase(String filterDbStr) {
        Cursor monCurseur2;
        if (filterDbStr.isEmpty()) {
            monCurseur2 = maSQLdb.lireTable();
        } else {
            try {
                int result = Integer.parseInt(filterDbStr);
                monCurseur2 = maSQLdb.lireTable(result);
            } catch (NumberFormatException noInt) {
                monCurseur2 = maSQLdb.lireTable(filterDbStr);
            }
        }
        if (monCurseur2.getCount() == 0) {
            Toast.makeText(MainActivity.this, "Aucun résultat trouvé.", Toast.LENGTH_SHORT).show();
        } else {
            afficherResultats(monCurseur2);
        }
    }

    private void afficherResultats(Cursor curseur) {
        ArrayList<HashMap<String, String>> listItem = new ArrayList<>();
        curseur.moveToFirst();
        while (!curseur.isAfterLast()) {
            HashMap<String, String> map = new HashMap<>();
            map.put("id", "Id : " + curseur.getInt(0));
            map.put("nom", "Nom : " + curseur.getString(1));
            map.put("prenom", "Prenom : " + curseur.getString(2));
            map.put("age", "Age : " + curseur.getInt(3));
            listItem.add(map);
            curseur.moveToNext();
        }
        curseur.close();

        SimpleAdapter monAdapter = new SimpleAdapter(this,
                listItem,
                R.layout.affichage_item,
                new String[]{"id", "nom", "prenom", "age"},
                new int[]{R.id.textView, R.id.textView2, R.id.textView3, R.id.textView4});
        maListView.setAdapter(monAdapter);
    }
}
