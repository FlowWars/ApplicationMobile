package com.example.projetapplication2022;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "MySQL";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME_LIVRE = "Librairy";
   // private static final String TABLE_NAME_Lecteur = "Users";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String EDITORS = "Editors";

    // below variable id for our course duration column.
    private static final String TITLE = "Title";

    // below variable for our course description column.
    private static final String AUTHORS = "Authors";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME_LIVRE + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EDITORS + " TEXT,"
                + TITLE + " TEXT,"
                + AUTHORS + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewCourse(String EDITORSname, String TITLEname, String AUTHORSname) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(EDITORS, EDITORSname);
        values.put(TITLE, TITLEname);
        values.put(AUTHORS, AUTHORSname);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME_LIVRE, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_LIVRE);
        onCreate(db);
    }
}
