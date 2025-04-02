package com.example.aninterface;

public class Personnage {
        private String nom;
        private int vita;
        private int force;

        private int vitesse;
        private int mana;

    public Personnage(String nom, int vita, int force, int vitesse, int mana){
            this.nom=nom;
            this.vita=vita;
            this.force=force;
            this.vitesse=vitesse;
            this.mana=mana;

    }

    public Personnage (String nom){
        this.nom=nom;
        vita=1500;
        force=346;
        vitesse=679;
        mana=582;
    }

    public void perteDePv (int pvPerdu){
        vita -= pvPerdu;
    }

    public interface MegaStats {
        public void augmenteForce(int f);
        public void augmenteVie(int v);
        public void augmenteMana(int m);
        public void changeNom(String s);
        public void changeCouleur(int c);
    }

    public String getNom(){
        return nom;
    }

    public int getVita() {
        return vita;
    }

    public int getForce() {
        return force;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getMana() {
        return mana;
    }

    public void setNom (String nom){
        this.nom = nom;
    }
    public void setVita(int vita) {
        this.vita = vita;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

}
