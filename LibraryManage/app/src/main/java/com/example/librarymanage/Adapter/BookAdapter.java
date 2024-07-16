package com.example.librarymanage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librarymanage.Entity.Author;
import com.example.librarymanage.Entity.Book;
import com.example.librarymanage.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{
    private List<Book> bookList;
    private List<Author> authorList;
    Context context;
    public BookAdapter(Context context, List<Book> book, List<Author> author) {
        this.context = context;
        this.bookList = book;
        this.authorList = author;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BookViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.book_container,
                        parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.bookName.setText(bookList.get(position).getBookName());
        holder.author.setText(authorList.get(position).getAuthorName());
        Picasso.get().load(bookList.get(position).getImage()).into(holder.bookImageView);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder{
        TextView bookName, author;
        ShapeableImageView bookImageView;
        BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bookName = itemView.findViewById(R.id.book_name);
            author = itemView.findViewById(R.id.author_name);
            bookImageView = itemView.findViewById(R.id.book_image);
        }
    }
}
