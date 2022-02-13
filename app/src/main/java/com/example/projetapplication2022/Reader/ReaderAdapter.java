package com.example.projetapplication2022.Reader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetapplication2022.R;

import java.util.ArrayList;

public class ReaderAdapter extends RecyclerView.Adapter<ReaderAdapter.ReaderHolder>{

    private ArrayList id_reader, firstname_reader, lastname_reader, email_reader;
    private Context context;

    // Constructeur de la classe
    ReaderAdapter(Context context, ArrayList id_reader, ArrayList firstname_reader, ArrayList lastname_reader, ArrayList email_reader){
        this.context = context;
        this.id_reader = id_reader;
        this.firstname_reader = firstname_reader;
        this.lastname_reader = lastname_reader;
        this.email_reader = email_reader;
    }

    // créer un nouveau RecyclerView.ViewHolder
    @NonNull
    @Override
    public ReaderAdapter.ReaderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layoutlinereader, parent, false);
        return new ReaderAdapter.ReaderHolder(view);
    }

    // configure les champs privés à utiliser par RecyclerView.
    @Override
    public void onBindViewHolder(@NonNull ReaderAdapter.ReaderHolder holder, int position) {
        holder.textViewIdentifiant.setText(String.valueOf(id_reader.get(position)));
        holder.textViewFirstname.setText(String.valueOf(firstname_reader.get(position)));
        holder.textViewLastname.setText(String.valueOf(lastname_reader.get(position)));
        holder.textViewEmail.setText(String.valueOf(email_reader.get(position)));
    }

    // Retourne le nombre total d'éléments dans l'ensemble de données détenu par l'adaptateur.
    @Override
    public int getItemCount() {
        return id_reader.size();
    }

    // Classe Holder
    public class ReaderHolder extends RecyclerView.ViewHolder {

        private TextView textViewIdentifiant, textViewFirstname, textViewLastname, textViewEmail;

        // constructeur de la classe
        public ReaderHolder(@NonNull View itemView) {
            super(itemView);

            textViewIdentifiant = itemView.findViewById(R.id.id_textView_identifiantReader);
            textViewFirstname = itemView.findViewById(R.id.id_textView_firstname);
            textViewLastname = itemView.findViewById(R.id.id_textView_lastname);
            textViewEmail = itemView.findViewById(R.id.id_textView_email);
        }
    }


}
