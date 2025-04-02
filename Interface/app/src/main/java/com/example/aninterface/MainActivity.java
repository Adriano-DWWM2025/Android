package com.example.aninterface;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements Personnage.MegaStats{
    private Personnage perso1, perso2, perso3;
    private TextView infoPerso1, infoPerso2, infoPersoM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         infoPerso1 = findViewById(R.id.infoPerso1);
         infoPerso2 = findViewById(R.id.infoPerso2);
         infoPersoM = findViewById(R.id.infoPersoM);

         perso1 = new Personnage("Sung Jin-Woo", 3000,512,717,10000);
         perso2 = new Personnage("Beru");
         perso3 = new Magicien("Choi Jon-In", 800, 143, 74, 640);

        perso2.perteDePv(10);

        augmenteForce(88);
        augmenteVie(100);
        augmenteMana(100);
        changeNom("Empereur des ténèbres");
        changeCouleur(Color.MAGENTA);
        String stats =  "Nom : " + perso1.getNom() + "\n" +
                        "HP : " + perso1.getVita() + "\n" +
                        "Force : " + perso1.getForce() + "\n" +
                        "Speed : " + perso1.getVitesse() + "\n" +
                        "Mana : " + perso1.getMana();

        infoPerso1.setText(stats);


        String statsDefault =   "Nom : " + perso2.getNom() + "\n" +
                                "HP : " + perso2.getVita() + "\n" +
                                "Force : " + perso2.getForce() + "\n" +
                                "Speed : " + perso2.getVitesse() + "\n" +
                                "Mana : " + perso2.getMana();



        infoPerso2.setText(statsDefault);

        String statsMage =   "Nom : " + perso3.getNom() + "\n" +
                "HP : " + perso3.getVita() + "\n" +
                "Force : " + perso3.getForce() + "\n" +
                "Speed : " + perso3.getVitesse() + "\n" +
                "Mana : " + perso3.getMana();



        infoPersoM.setText(statsMage);


    };

    @Override
    public void augmenteForce(int f) {
        perso1.setForce(f);
    }

    @Override
    public void augmenteVie(int v) {
        perso1.setVita(v);
    }

    @Override
    public void augmenteMana(int m) {
        perso1.setMana(m);
    }

    @Override
    public void changeNom(String s) {
        perso1.setNom(s);
    }

    @Override
    public void changeCouleur(int c) {
        infoPerso1.setTextColor(c);
    }

}