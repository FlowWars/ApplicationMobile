package com.example.projetapplication2022;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    // initialisation des variables

    // variable du contexte de l'etat actuel de l'application
    private Context context;
    // variable du nom de la base de données
    private static final String DB_NAME = "MySQL";

    // variable de la version de la base de données
    private static final int DB_VERSION = 1;

    // variable du nom de la table livre
    private static final String TABLE_NAME_LIVRE = "Book";

    // variable du nom de la table lecteur
    private static final String TABLE_NAME_LECTEUR = "Reader";

    // variable de la colonne identifiant
    private static final String ID_COL = "id";

    // variable de la colonne editeur
    private static final String EDITORS = "Editors";

    // variable de la colonne titre
    private static final String TITLE = "Title";

    // variable de la colonne auteur
    private static final String AUTHORS = "Authors";

    // variable de la colonne prenom
    private static final String FIRSTNAME = "Firstname";

    // variable de la colonne nom
    private static final String LASTNAME = "Lastname";

    // variable de la colonne email
    private static final String EMAIL = "Email";

    // Constructeur
    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    // méthode pour créer les tables livre et lecteur
    @Override
    public void onCreate(SQLiteDatabase db) {

        // création de la table livre si elle n'existe pas
        String queryTableBook = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_LIVRE + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EDITORS + " TEXT NOT NULL,"
                + TITLE + " TEXT NOT NULL,"
                + AUTHORS + " TEXT NOT NULL)";

        // création de la table lecteur si elle n'existe pas
        String queryTableReader = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_LECTEUR + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FIRSTNAME + " TEXT NOT NULL,"
                + LASTNAME + " TEXT NOT NULL,"
                + EMAIL + " TEXT NOT NULL)";

        // exécution des requêtes sql
        db.execSQL(queryTableBook);
        db.execSQL(queryTableReader);
    }

    // méthode pour insérer un livre dans la table livre
    public void insertBook(String AUTHORSname, String EDITORSname, String TITLEname) {

        // Ouvre la base de données qui sera utilisé pour l'écriture des données
        SQLiteDatabase db = this.getWritableDatabase();

        // Créer un ensemble vide de valeurs en utilisant la taille initiale par défaut
        ContentValues valuesBook = new ContentValues();

        // Ajoute les valeurs respectives dans l'ensemble valuesBook
        valuesBook.put(EDITORS, EDITORSname);
        valuesBook.put(TITLE, TITLEname);
        valuesBook.put(AUTHORS, AUTHORSname);

        // Insertion des valeurs dans la table livre
        long res = db.insert(TABLE_NAME_LIVRE, null, valuesBook);
        if(res == -1){
            Toast.makeText(context, "Echec", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Insertion effectuée", Toast.LENGTH_SHORT).show();
        }

        // deconnexion de la base de données
        db.close();
    }

    // méthode pour insérer un lecteur dans la table lecteur
    public void insertReader(String Firstname, String Lastname, String Email) {

        // Ouvre la base de données qui sera utilisé pour l'écriture des données
        SQLiteDatabase db = this.getWritableDatabase();

        // Créer un ensemble vide de valeurs en utilisant la taille initiale par défaut
        ContentValues valuesReader = new ContentValues();

        // Ajoute les valeurs respectives dans l'ensemble valuesReader
        valuesReader.put(FIRSTNAME, Firstname);
        valuesReader.put(LASTNAME, Lastname);
        valuesReader.put(EMAIL, Email);

        // Ajout des valeurs dans la table lecteur
        long res = db.insert(TABLE_NAME_LECTEUR, null, valuesReader);
        if(res == -1){
            Toast.makeText(context, "Echec", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Insertion effectuée", Toast.LENGTH_SHORT).show();
        }

        // deconnexion de la base de données
        db.close();
    }

    // méthode pour supprimer les tables si les tables existent déjà
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_LIVRE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_LECTEUR);
        onCreate(db);
    }

    // méthode pour récupérer toutes les données de la table livre
    public Cursor ReadDataBook(){
        String query = "SELECT * FROM " + TABLE_NAME_LIVRE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    // méthode pour récupérer toutes les données de la table lecteur
    public Cursor ReadDataReader(){
        String query = "SELECT * FROM " + TABLE_NAME_LECTEUR;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
