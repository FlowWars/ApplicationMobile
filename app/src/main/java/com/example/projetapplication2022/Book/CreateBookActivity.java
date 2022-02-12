package com.example.projetapplication2022.Book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetapplication2022.MainActivity;
import com.example.projetapplication2022.R;

public class CreateBookActivity extends AppCompatActivity {

    private EditText edt_title, edt_author, edt_editor;
    private String title, author, editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_create_book);

        edt_title = findViewById(R.id.id_editTextTitle);
        edt_author = findViewById(R.id.id_editTextAuthor);
        edt_editor = findViewById(R.id.id_editTextEditor);
    }

    public void onClickValidCreateBook(View view) {

        title = edt_title.getText().toString();
        author = edt_author.getText().toString();
        editor = edt_editor.getText().toString();

        Intent mainActivity = new Intent(this, MainActivity.class);
        Bundle bundleBook = new Bundle();
        bundleBook.putString("cle_title", title);
        bundleBook.putString("cle_author", author);
        bundleBook.putString("cle_editor", editor);

        mainActivity.putExtras(bundleBook);
        startActivity(mainActivity);
    }
}