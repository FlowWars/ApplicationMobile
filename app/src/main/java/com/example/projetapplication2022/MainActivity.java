package com.example.projetapplication2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

        databaseManager = new DBHandler(this);

        Bundle bundleBook = getIntent().getExtras();
        Bundle bundleReader = getIntent().getExtras();
        if (bundleBook != null){
            String title = bundleBook.getString("cle_title");
            String author = bundleBook.getString("cle_author");
            String editor = bundleBook.getString("cle_editor");

            databaseManager.insertBook(author, editor, title);
        }
        if (bundleReader != null){
            String firstname = bundleReader.getString("cle_firstname");
            String lastname = bundleReader.getString("cle_lastname");
            String email = bundleReader.getString("cle_email");

            databaseManager.insertReader(firstname, lastname, email);
        }

        databaseManager.close();
    }

    public void onClickCreateBook(View view) {

        Intent intent = new Intent(this, CreateBookActivity.class);
        startActivity(intent);
    }

    public void onClickCreateReader(View view) {

        Intent intent = new Intent(this, CreateReaderActivity.class);
        startActivity(intent);
    }

    public void onClickDisplayBook(View view) {

        Intent intent = new Intent(this, DisplayListBookActivity.class);
        startActivity(intent);
    }

    public void onClickDisplayReader(View view) {

        Intent intent = new Intent(this, DisplayListReaderActivity.class);
        startActivity(intent);
    }
}