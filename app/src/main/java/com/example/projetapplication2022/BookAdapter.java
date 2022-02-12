package com.example.projetapplication2022;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> {

    private ArrayList id_book, title_book, author_book, editor_book;
    private Context context;

    BookAdapter(Context context, ArrayList id_book, ArrayList title_book, ArrayList author_book, ArrayList editor_book){
        this.context = context;
        this.id_book = id_book;
        this.title_book = title_book;
        this.author_book = author_book;
        this.editor_book = editor_book;
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layoutlinebook, parent, false);
        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {
        holder.textViewIdentifiant.setText(String.valueOf(id_book.get(position)));
        holder.textViewTitle.setText(String.valueOf(title_book.get(position)));
        holder.textViewAuthor.setText(String.valueOf(author_book.get(position)));
        holder.textViewEditor.setText(String.valueOf(editor_book.get(position)));
    }

    @Override
    public int getItemCount() {
        return id_book.size();
    }

    public class BookHolder extends RecyclerView.ViewHolder {

        private TextView textViewIdentifiant, textViewTitle, textViewAuthor, textViewEditor;

        public BookHolder(@NonNull View itemView) {
            super(itemView);

            textViewIdentifiant = itemView.findViewById(R.id.id_textView_identifiant);
            textViewTitle = itemView.findViewById(R.id.id_textView_title);
            textViewAuthor = itemView.findViewById(R.id.id_textView_author);
            textViewEditor = itemView.findViewById(R.id.id_textView_editor);
        }
    }
}
