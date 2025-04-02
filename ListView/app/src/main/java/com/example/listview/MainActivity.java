package com.example.listview;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ListView maListViewPerso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        maListViewPerso = findViewById(R.id.listViewPerso);


        ArrayList<HashMap<String,String>> listItem = new ArrayList<HashMap<String,String>>();


        HashMap<String,String> map;

        map = new HashMap<String, String>();
        map.put("titre", "Mario");
        map.put("description", "Rejouez les aventures du plus célèbre des plombiers");
        map.put("img", String.valueOf(R.drawable.plant));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "RL");
        map.put("description", "Jouez au football en voiture (logique)");
        map.put("img", String.valueOf(R.drawable.rl));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Rito");
        map.put("description", "Perdez votre joie sur la faille");
        map.put("img", String.valueOf(R.drawable.rito));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Emulateur GameBoy");
        map.put("description", "Rejouez aux jeux de votre enfance");
        map.put("img", String.valueOf(R.drawable.jeu));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "k2");
        map.put("description", "NBA2K mais en moins bien");
        map.put("img", String.valueOf(R.drawable.k2));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "FallGuys");
        map.put("description", "Faites du parkour avec le perso le moins facile à controler du monde");
        map.put("img", String.valueOf(R.drawable.fall));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "JO");
        map.put("description", "Les jeux olympiques mais sans Mario & Sonic");
        map.put("img", String.valueOf(R.drawable.game));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "FF14");
        map.put("description", "Incarnez un héros avec une épée qui fait le quadrupple de votre taille");
        map.put("img", String.valueOf(R.drawable.fantasy));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Minecraft");
        map.put("description", "Laissez libre cours à votre imagination dans un monde cubique infini.");
        map.put("img", String.valueOf(R.drawable.minecraft));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Valorant");
        map.put("description", "Un jeu de tir compétitif où les réflexes rencontrent la stratégie.");
        map.put("img", String.valueOf(R.drawable.valorant));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "The Witcher 3");
        map.put("description", "Incarnez Geralt de Riv et partez à la chasse aux monstres (et aux contrats).");
        map.put("img", String.valueOf(R.drawable.witcher));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Animal Crossing");
        map.put("description", "Créez votre île paradisiaque et faites ami avec ses habitants.");
        map.put("img", String.valueOf(R.drawable.crossing));
        listItem.add(map);


        map = new HashMap<String, String>();
        map.put("titre", "Overwatch 2");
        map.put("description", "Un FPS dynamique avec des héros uniques et des combats d’équipe intenses.");
        map.put("img", String.valueOf(R.drawable.overwatch));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Genshin Impact");
        map.put("description", "Explorez Teyvat avec style dans cette aventure riche et gratuite.");
        map.put("img", String.valueOf(R.drawable.genshin));
        listItem.add(map);


        SimpleAdapter monAdapter = new SimpleAdapter (this.getBaseContext(),listItem, R.layout.affichage_item, new String[] {"img","titre","description"}, new int[] {R.id.imageView, R.id.textView, R.id.textView2});

        maListViewPerso.setAdapter(monAdapter);

    }
}
