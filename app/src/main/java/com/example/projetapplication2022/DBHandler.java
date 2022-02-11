package com.example.projetapplication2022;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    // initialisation des variables
    // variable du nom de la base de données
    private static final String DB_NAME = "MySQL";

    // variable de la version de la base de données
    private static final int DB_VERSION = 1;

    // variable du nom de la table livre
    private static final String TABLE_NAME_LIVRE = "Book";

    // variable du nom de la table lecteur
    private static final String TABLE_NAME_LECTEUR = "Reader";

    //
    private static final String ID_COL = "id";

    //
    private static final String EDITORS = "Editors";

    //
    private static final String TITLE = "Title";

    //
    private static final String AUTHORS = "Authors";

    //
    private static final String FIRSTNAME = "Firstname";

    //
    private static final String LASTNAME = "Lastname";

    //
    private static final String EMAIL = "Email";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //
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

    //
    public void insertBook(String AUTHORSname, String EDITORSname, String TITLEname) {

        //
        SQLiteDatabase db = this.getWritableDatabase();

        //
        ContentValues valuesBook = new ContentValues();

        //
        valuesBook.put(EDITORS, EDITORSname);
        valuesBook.put(TITLE, TITLEname);
        valuesBook.put(AUTHORS, AUTHORSname);

        // Ajout des valeurs dans la table livre
        db.insert(TABLE_NAME_LIVRE, null, valuesBook);

        // deconnexion de la base de données
        db.close();
    }

    public void insertReader(String Firstname, String Lastname, String Email) {

        //
        SQLiteDatabase db = this.getWritableDatabase();

        //
        ContentValues valuesReader = new ContentValues();

        //
        valuesReader.put(FIRSTNAME, Firstname);
        valuesReader.put(LASTNAME, Lastname);
        valuesReader.put(EMAIL, Email);

        // Ajout des valeurs dans la table lecteur
        db.insert(TABLE_NAME_LECTEUR, null, valuesReader);

        // deconnexion de la base de données
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Cette méthode est appelée pour vérifier si les tables existent déjà
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_LIVRE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_LECTEUR);
        onCreate(db);
    }
}
