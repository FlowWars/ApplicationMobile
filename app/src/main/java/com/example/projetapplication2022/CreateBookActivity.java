package com.example.projetapplication2022;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;

public class CreateBookActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText courseName, courseTracksEdt, courseDurationEdt, courseDescriptionEdt;
    private Button addCourseBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_create_book);


        // initializing all our variables.
        courseName = findViewById(R.id.editTextAuthor);
        courseTracksEdt = findViewById(R.id.editTextEditor);
        courseDurationEdt = findViewById(R.id.editTextTitle);
        addCourseBtn = findViewById(R.id.id_btn_validCreateBook);



    }

    public void onClickValidCreateBook(View view) {
    }
}