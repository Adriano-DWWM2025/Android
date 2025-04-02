package com.example.spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        spinner = findViewById(R.id.spinner);
        arrayList = new ArrayList<>();
        arrayList.add("Choisissez votre boisson");
        arrayList.add("Coca-Cola");
        arrayList.add("Orangina");
        arrayList.add("Oasis");
        arrayList.add("Fanta");
        arrayList.add("Lipton");
        arrayList.add("Ajouter un choix");


        ArrayAdapter arrayAdapter = new ArrayAdapter<>(MainActivity.this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arrayList);


        arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(MainActivity.this, "oraoraoraoraoraoraoraoraora", Toast.LENGTH_SHORT).show();
                } else {
                    String monItem = parent.getItemAtPosition(position).toString();
                    Toast.makeText(MainActivity.this, "id "+ id + " position " + position + " sur " + monItem, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "une erreur est survenue", Toast.LENGTH_SHORT).show();

            }
        });
    }
}