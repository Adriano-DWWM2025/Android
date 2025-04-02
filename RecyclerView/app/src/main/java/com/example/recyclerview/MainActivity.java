package com.example.recyclerview;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MonAdapter monAdapter;
    private RecyclerView recyclerView;
    private List<Items> mesItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.monRecyclerView);
        mesItems = new ArrayList<>();


        mesItems.add(new Items(R.drawable.axolotl, "Axolotl Chiffonné", "Ce poisson-là a oublié d'évoluer, mais il est mignon !"));
        mesItems.add(new Items(R.drawable.hibou, "Hibou Incognito", "Sa tête tourne mieux qu'une caméra de surveillance."));
        mesItems.add(new Items(R.drawable.koala, "Koala KO", "Il dort 20 heures par jour, un vrai champion du dodo !"));
        mesItems.add(new Items(R.drawable.cerf, "Cerf VIP", "Avec ses bois, il capte toutes les chaînes TV."));
        mesItems.add(new Items(R.drawable.elephant, "Éléphant Méga Mémoire", "Il se souvient encore de la pub qu'il a vue en 1999."));
        mesItems.add(new Items(R.drawable.serpent, "Serpent Cool", "Pas de jambes, pas de problème. Il se faufile tranquille."));
        mesItems.add(new Items(R.drawable.lion, "Lion Colérique", "Quand il rugit, tout le monde fait «shh»."));
        mesItems.add(new Items(R.drawable.panda, "Panda Goinfre", "9 kg de bambou par jour, c'est son régime de star."));
        mesItems.add(new Items(R.drawable.girafe, "Girafe Perchée", "Elle voit tes problèmes arriver avant toi."));
        mesItems.add(new Items(R.drawable.chat, "Chat Seigneur", "Il te juge depuis le canapé... et il a raison."));
        mesItems.add(new Items(R.drawable.chien, "Chien Enthousiaste", "Toujours prêt à jouer, même à 3 heures du mat."));
        mesItems.add(new Items(R.drawable.hamster, "Hamster Runner", "Marathonien en roues libres, sans destination."));
        mesItems.add(new Items(R.drawable.lapin, "Lapin Turbo", "Plus rapide que ton Wi-Fi quand il stresse."));
        mesItems.add(new Items(R.drawable.singe, "Singe Farceur", "Il adore te balancer des noix de coco sur la tête."));
        mesItems.add(new Items(R.drawable.tortue, "Tortue Zen", "Elle arrive toujours en retard... mais elle arrive."));
        mesItems.add(new Items(R.drawable.zebre, "Zèbre Fashionista", "Jamais démodé avec ses rayures éternelles."));

        monAdapter = new MonAdapter(mesItems, this);

//        LinearLayoutManager layoutManager  = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);

        int orientation = getResources().getConfiguration().orientation;

        if (Configuration.ORIENTATION_LANDSCAPE == orientation) {

            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
        } else
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        recyclerView.setAdapter(monAdapter);

        EffetSwipe effetSwipe = new EffetSwipe(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, MainActivity.this, mesItems, monAdapter);
        new ItemTouchHelper(effetSwipe).attachToRecyclerView(recyclerView);

    }
}

