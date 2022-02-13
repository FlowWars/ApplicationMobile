package com.example.projetapplication2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projetapplication2022.Book.CreateBookActivity;
import com.example.projetapplication2022.Book.DisplayListBookActivity;
import com.example.projetapplication2022.Reader.CreateReaderActivity;
import com.example.projetapplication2022.Reader.DisplayListReaderActivity;

public class MainActivity extends AppCompatActivity {

    private Button btn_createBook, btn_createReader, btn_listBook, btn_listReader;
    private DBHandler databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_createBook = findViewById(R.id.id_btn_createBook);
        btn_createReader = findViewById(R.id.id_btn_createReader);
        btn_listBook = findViewById(R.id.id_btn_listBook);
        btn_listReader = findViewById(R.id.id_btn_listReader);

        // instanciation de la classe DBHandler
        databaseManager = new DBHandler(this);

        // Initialisation des bundles
        Bundle bundleBook = getIntent().getExtras();
        Bundle bundleReader = getIntent().getExtras();
        if (bundleBook != null){
            // récupération des valeurs du bundle provenant de l'activité CreateBook à l'aide de clé
            String title = bundleBook.getString("cle_title");
            String author = bundleBook.getString("cle_author");
            String editor = bundleBook.getString("cle_editor");

            // Appel de la méthode insertBook
            databaseManager.insertBook(author, editor, title);
        }
        if (bundleReader != null){
            // récupération des valeurs du bundle provenant de l'activité CreateReader à l'aide de clé
            String firstname = bundleReader.getString("cle_firstname");
            String lastname = bundleReader.getString("cle_lastname");
            String email = bundleReader.getString("cle_email");

            // Appel de la méthode insertReader
            databaseManager.insertReader(firstname, lastname, email);
        }
        databaseManager.close();
    }

    // Accès à l'activité de création de livre
    public void onClickCreateBook(View view) {

        Intent intent = new Intent(this, CreateBookActivity.class);
        startActivity(intent);
    }

    // Accès à l'activité de création de lecteur
    public void onClickCreateReader(View view) {

        Intent intent = new Intent(this, CreateReaderActivity.class);
        startActivity(intent);
    }

    // Accès à l'activité qui affiche la liste de livre inséré dans la base de données
    public void onClickDisplayBook(View view) {

        Intent intent = new Intent(this, DisplayListBookActivity.class);
        startActivity(intent);
    }

    // Accès à l'activité qui affiche la liste de lecteur inséré dans la base de données
    public void onClickDisplayReader(View view) {

        Intent intent = new Intent(this, DisplayListReaderActivity.class);
        startActivity(intent);
    }
}