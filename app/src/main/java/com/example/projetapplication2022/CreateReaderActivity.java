package com.example.projetapplication2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateReaderActivity extends AppCompatActivity {

    private EditText edt_firstname, edt_lastname, edt_email;
    private String firstname, lastname, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_create_reader);

        edt_firstname = findViewById(R.id.id_editTextFirstname);
        edt_lastname = findViewById(R.id.id_editTextLastname);
        edt_email = findViewById(R.id.id_editTextEmail);
    }

    public void onClickValidCreateReader(View view) {

        firstname = edt_firstname.getText().toString();
        lastname = edt_lastname.getText().toString();
        email = edt_email.getText().toString();

        Intent mainActivity = new Intent(this, MainActivity.class);
        Bundle bundleReader = new Bundle();
        bundleReader.putString("cle_firstname", firstname);
        bundleReader.putString("cle_lastname", lastname);
        bundleReader.putString("cle_email", email);

        mainActivity.putExtras(bundleReader);
        startActivity(mainActivity);
    }
}