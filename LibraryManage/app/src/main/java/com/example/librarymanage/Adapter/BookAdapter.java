package com.example.librarymanage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librarymanage.DTO.BookDTO;
import com.example.librarymanage.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{
    private List<BookDTO> book;
    Context context;
    public BookAdapter(Context context, List<BookDTO> book) {
        this.context = context;
        this.book = book;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BookViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.book_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.bookName.setText(book.get(position).getBookName());
//        holder.author.setText(book.get(position).getAuthorName());
        holder.bookImageView.setImageResource(R.drawable.ic_launcher_background);
    }

    @Override
    public int getItemCount() {
        return book.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder{
        TextView bookName, author;
        RoundedImageView bookImageView;
        BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bookName = itemView.findViewById(R.id.book_name);
            author = itemView.findViewById(R.id.author_name);
            bookImageView = itemView.findViewById(R.id.book_image);
        }
    }
}
