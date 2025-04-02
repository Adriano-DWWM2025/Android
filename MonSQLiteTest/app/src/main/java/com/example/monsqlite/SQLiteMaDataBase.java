package com.example.monsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteMaDataBase extends SQLiteOpenHelper {

    public static final String BASE_NOM = "MaBase.db";
    public static final int BASE_VERSION = 2;
    public static final String NOM_TABLE = "T_clients";
    public static final String COL0 = "IdClient";
    public static final String COL1 = "NOM";
    public static final String COL2 = "PRENOM";
    public static final String COL3 = "AGE";

    public SQLiteMaDataBase(Context context) {
        super(context, BASE_NOM, null, BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSql = "CREATE TABLE " + NOM_TABLE + " ("
                + COL0 + " integer primary key autoincrement, "
                + COL1 + " text not null, "
                + COL2 + " text not null, "
                + COL3 + " integer not null);";
        Log.d("DataBase", "strSql " + strSql);
        db.execSQL(strSql);
        Log.d("DataBase", "Création de la Base de donnée OK " + NOM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String strSql = "DROP TABLE IF EXISTS " + NOM_TABLE;
        Log.d("DataBase", "Requête SQL pour onUpgrade: " + strSql);
        db.execSQL(strSql);
        onCreate(db);
        Log.d("DataBase", "Méthode onUpgrade exécutée. Table recréée: " + NOM_TABLE);
    }

    public void insertionCLIENTS(String NOM, String PRENOM, Integer AGE) {
        String strSql = "INSERT INTO " + NOM_TABLE + " ("
                + COL1 + ", " + COL2 + ", " + COL3 + ") "
                + "values ('" + NOM + "', '" + PRENOM + "', " + AGE + ");";
        Log.d("DataBase", "Ins sql: " + strSql);
        getWritableDatabase().execSQL(strSql);
        Log.d("DataBase", "Données insérées, insertion OK");
    }

    public Cursor lireTable() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor monCurseur = db.rawQuery("select * from " + NOM_TABLE, null);
        return monCurseur;

//        Cursor monCurseur;
//
//        if (colonne == null || valeur == null) {
//            monCurseur = db.rawQuery("SELECT * FROM " + NOM_TABLE, null);
//        } else {
//
//            String query = "SELECT * FROM " + NOM_TABLE + " WHERE `" + colonne + "` LIKE ?";
//            String[] args = {"%" + String.valueOf(valeur) + "%"};
//            monCurseur = db.rawQuery(query, args);
//        }

    }
    public Cursor lireTable(int idAge) {
        SQLiteDatabase db = this.getReadableDatabase();
        String strSql = "SELECT * FROM " + NOM_TABLE +
                " WHERE CAST(" + COL3 + " AS TEXT) LIKE '%" + idAge + "%';";
        Log.d("Database", "Requête SQL : " + strSql);
        Cursor monCurseur = db.rawQuery(strSql, null);
        return monCurseur;
    }


    public Cursor lireTable(String nomPrenom) {
        SQLiteDatabase db = this.getReadableDatabase();
        String strSql = "SELECT * FROM " + NOM_TABLE +
                " WHERE " + COL1 + " LIKE ? OR " + COL2 + " LIKE ?;";
        String[] args = new String[]{"%" + nomPrenom + "%", "%" + nomPrenom + "%"};
        return db.rawQuery(strSql, args);
    }
}
