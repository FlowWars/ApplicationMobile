package com.example.projetapplication2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class DisplayListReaderActivity extends AppCompatActivity {

    private RecyclerView recyclerViewReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_display_list_reader);

        this.recyclerViewReader=findViewById(R.id.id_recyclerView_reader);
    }


}