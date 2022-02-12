package com.example.projetapplication2022.Reader;

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

public class DisplayListReaderActivity extends AppCompatActivity {

    private RecyclerView recyclerViewReader;
    private DBHandler db;
    private ArrayList<String> id_reader, firstname_reader, lastname_reader, email_reader;
    private ReaderAdapter readerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_display_list_reader);

        this.recyclerViewReader=findViewById(R.id.id_recyclerView_reader);

        db = new DBHandler(this);
        id_reader = new ArrayList<>();
        firstname_reader = new ArrayList<>();
        lastname_reader = new ArrayList<>();
        email_reader = new ArrayList<>();

        storeDataReader();

        readerAdapter = new ReaderAdapter(this, id_reader, firstname_reader, lastname_reader, email_reader);
        recyclerViewReader.setAdapter(readerAdapter);
        recyclerViewReader.setLayoutManager(new LinearLayoutManager(this));
    }

    void storeDataReader(){

        Cursor cursor = db.ReadDataReader();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "Table vide", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                id_reader.add(cursor.getString(0));
                firstname_reader.add(cursor.getString(1));
                lastname_reader.add(cursor.getString(2));
                email_reader.add(cursor.getString(3));
            }
        }
    }


}