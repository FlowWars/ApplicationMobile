package com.example.projetapplication2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class DisplayListBookActivity extends AppCompatActivity {

    private RecyclerView RecyclerViewBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_display_list_book);

        this.RecyclerViewBook=findViewById(R.id.id_recyclerView_book);
    }
}