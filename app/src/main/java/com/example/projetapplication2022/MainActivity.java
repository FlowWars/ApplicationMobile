package com.example.projetapplication2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_createBook, btn_createReader, btn_listBook, btn_listReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_createBook = findViewById(R.id.id_btn_createBook);
        btn_createReader = findViewById(R.id.id_btn_createReader);
        btn_listBook = findViewById(R.id.id_btn_listBook);
        btn_listReader = findViewById(R.id.id_btn_listReader);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String title = bundle.getString("cle_title");
            String author = bundle.getString("cle_author");
            String editor = bundle.getString("cle_editor");
            Toast.makeText(this,title + " " + author + " " + editor, Toast.LENGTH_LONG).show();
        }
    }

    public void onClickCreateBook(View view) {

        Intent intent = new Intent(this, CreateBookActivity.class);
        startActivity(intent);
    }

    public void onClickCreateReader(View view) {

        Intent intent = new Intent(this, CreateReaderActivity.class);
        startActivity(intent);
    }
}