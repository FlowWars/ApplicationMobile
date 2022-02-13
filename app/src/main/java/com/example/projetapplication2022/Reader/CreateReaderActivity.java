package com.example.projetapplication2022.Reader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetapplication2022.MainActivity;
import com.example.projetapplication2022.R;

public class CreateReaderActivity extends AppCompatActivity {

    private EditText edt_firstname, edt_lastname, edt_email;
    private String firstname, lastname, email;
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_create_reader);

        edt_firstname = findViewById(R.id.id_editTextFirstname);
        edt_lastname = findViewById(R.id.id_editTextLastname);
        edt_email = findViewById(R.id.id_editTextEmail);
    }

    // méthode qui insère les valeurs des editText dans un bundle et l'envoie dans le mainActivity
    public void onClickValidCreateReader(View view) {

        // initialisation des valeurs
        firstname = edt_firstname.getText().toString();
        lastname = edt_lastname.getText().toString();
        email = edt_email.getText().toString();

        // Vérification des champs
        if(firstname.isEmpty() || lastname.isEmpty() || email.isEmpty()){
            Toast.makeText(this, "champ(s) vide(s)", Toast.LENGTH_SHORT).show();
        }else if(email.trim().matches(emailPattern) == false){
            Toast.makeText(this, "email invalide", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent mainActivity = new Intent(this, MainActivity.class);
            Bundle bundleReader = new Bundle();
            bundleReader.putString("cle_firstname", firstname);
            bundleReader.putString("cle_lastname", lastname);
            bundleReader.putString("cle_email", email);

            // envoie du bundle et démarrage du mainActivity
            mainActivity.putExtras(bundleReader);
            startActivity(mainActivity);
        }

    }
}