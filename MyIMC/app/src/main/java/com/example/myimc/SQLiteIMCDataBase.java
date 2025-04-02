package com.example.myimc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteIMCDataBase extends SQLiteOpenHelper {

    // Nom et version de la base
    public static final String BASE_NOM = "IMCBase.db";
    public static final int BASE_VERSION = 1;

    // Table IMC
    public static final String NOM_TABLE_IMC = "T_IMC";
    public static final String COL0 = "IdIMC";
    public static final String COL1 = "Poids";
    public static final String COL2 = "Taille";
    public static final String COL3 = "IMC";
    public static final String COL4 = "Date";

    // Table des activités sportives
    public static final String TABLE_ACTIVITES = "T_Activites";
    public static final String COL0_ACTIVITY = "IdActivity";
    public static final String COL1_ACTIVITY = "Nom";
    public static final String COL2_ACTIVITY = "Duree";


    public SQLiteIMCDataBase(Context context) {
        super(context, BASE_NOM, null, BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Création de la table IMC
        String strSqlIMC = "CREATE TABLE " + NOM_TABLE_IMC + " ("
                + COL0 + " integer primary key autoincrement, "
                + COL1 + " REAL not null, "
                + COL2 + " REAL not null, "
                + COL3 + " REAL not null, "
                + COL4 + " TEXT not null);";

        Log.d("DataBase", "Requête SQL de création IMC: " + strSqlIMC);
        db.execSQL(strSqlIMC);

        // Création de la table Activités sportives
        String strSqlActivities = "CREATE TABLE " + TABLE_ACTIVITES + " ("
                + COL0_ACTIVITY + " integer primary key autoincrement, "
                + COL1_ACTIVITY + " TEXT not null, "
                + COL2_ACTIVITY + " INTEGER not null);";

        Log.d("DataBase", "Requête SQL de création Activités: " + strSqlActivities);
        db.execSQL(strSqlActivities);

        Log.d("DataBase", "Création de la base de données OK (IMC et Activités)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop table IMC
        String strSqlIMC = "DROP TABLE IF EXISTS " + NOM_TABLE_IMC;
        Log.d("DataBase", "Requête SQL pour suppression IMC: " + strSqlIMC);
        db.execSQL(strSqlIMC);

        // Drop table Activités sportives
        String strSqlActivities = "DROP TABLE IF EXISTS " + TABLE_ACTIVITES;
        Log.d("DataBase", "Requête SQL pour suppression Activités: " + strSqlActivities);
        db.execSQL(strSqlActivities);

        onCreate(db);
    }

    public void insertionIMC(float poids, float taille, float imc, String date) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(COL1, poids);
        values.put(COL2, taille);
        values.put(COL3, imc);
        values.put(COL4, date);

        // Insertion dans la table
        db.insert(NOM_TABLE_IMC, null, values);

        // Ajout d'un log pour le suivi
        Log.d("SQLiteIMC", "Données insérées : Poids=" + poids + ", Taille=" + taille + ", IMC=" + imc + ", Date=" + date);

        db.close();
    }

    // Insertion d'une activité sportive
    public void insertionActivite(String nom, int duree) {
        String strSql = "INSERT INTO " + TABLE_ACTIVITES + " ("
                + COL1_ACTIVITY + ", " + COL2_ACTIVITY + ") "
                + "VALUES ('" + nom + "', " + duree + ");";
        Log.d("DataBase", "Insertion SQL activités: " + strSql);
        this.getWritableDatabase().execSQL(strSql);
    }

    // Lecture de toutes les activités sportives
    public Cursor lireToutesLesActivites() {
        String strSql = "SELECT * FROM " + TABLE_ACTIVITES + ";";
        Log.d("DataBase", "Requête SQL lecture activités: " + strSql);
        return this.getReadableDatabase().rawQuery(strSql, null);
    }

    public Cursor lireTableIMC() { // Notez que je change le nom pour plus de clarté
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + NOM_TABLE_IMC + ";"; // Requête SQL pour récupérer tout
        Log.d("DataBase", "Lecture des données de la table IMC");
        return db.rawQuery(sql, null);
    }
}
