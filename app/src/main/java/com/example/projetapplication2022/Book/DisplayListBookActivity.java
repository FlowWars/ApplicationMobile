package com.example.projetapplication2022.Book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.projetapplication2022.Book.BookAdapter;
import com.example.projetapplication2022.DBHandler;
import com.example.projetapplication2022.R;

import java.util.ArrayList;

public class DisplayListBookActivity extends AppCompatActivity {

    private RecyclerView recyclerViewBook;
    private DBHandler db;
    private ArrayList<String> id_book, title_book, author_book, editor_book;
    private BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_display_list_book);

        this.recyclerViewBook=findViewById(R.id.id_recyclerView_book);

        // instanciation des listes et de la base de données
        db = new DBHandler(this);
        id_book = new ArrayList<>();
        title_book = new ArrayList<>();
        author_book = new ArrayList<>();
        editor_book = new ArrayList<>();

        // appel de la méthode
        storeDataBook();

        // instanciation de l'adaptateur et met a jour le recyclerView
        bookAdapter = new BookAdapter(this, id_book, title_book, author_book, editor_book);
        recyclerViewBook.setAdapter(bookAdapter);
        recyclerViewBook.setLayoutManager(new LinearLayoutManager(this));
    }

    // méthode qui stocke les données de la table livre dans les listes respectives
    void storeDataBook(){

        Cursor cursor = db.ReadDataBook();
        if(cursor.getCount() == 0){
            // message si la table est vide
            Toast.makeText(this, "Table vide", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                id_book.add(cursor.getString(0));
                editor_book.add(cursor.getString(1));
                title_book.add(cursor.getString(2));
                author_book.add(cursor.getString(3));
            }
        }
    }
}