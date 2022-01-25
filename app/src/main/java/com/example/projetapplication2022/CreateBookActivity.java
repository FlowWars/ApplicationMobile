package com.example.projetapplication2022;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CreateBookActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText EDITORS, TITLE, AUTHORS;
    private Button addCourseBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_create_book);


        // initializing all our variables.
        AUTHORS = findViewById(R.id.editTextAuthor);
        EDITORS = findViewById(R.id.editTextEditor);
        TITLE = findViewById(R.id.editTextTitle);
        addCourseBtn = findViewById(R.id.id_btn_validCreateBook);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(CreateBookActivity.this);

        // below line is to add on click listener for our add course button.
        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String Authors = AUTHORS.getText().toString();
                String Editors = EDITORS.getText().toString();
                String Title = TITLE.getText().toString();

                // validating if the text fields are empty or not.
                if (Authors.isEmpty() && Editors.isEmpty() && Title.isEmpty()) {
                    Toast.makeText(CreateBookActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewCourse(Authors, Editors, Title);

                // after adding the data we are displaying a toast message.
                Toast.makeText(CreateBookActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                AUTHORS.setText("");
                EDITORS.setText("");
                TITLE.setText("");
                }
        });

    }

    public void onClickValidCreateBook(View view) {
    }
}