package com.example.librarymanage.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librarymanage.Entity.Author;
import com.example.librarymanage.R;

import java.util.List;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder> {
    private List<Author> authorList;
    public AuthorAdapter(List<Author> authorList) {
        this.authorList = authorList;
    }
    @NonNull
    @Override
    public AuthorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_author, parent, false);
        return new AuthorViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull AuthorViewHolder holder, int position) {
        Author author = authorList.get(position);
        holder.tvNo.setText(String.valueOf(position + 1));
        holder.tvBookName.setText(author.authorName);
    }
    @Override
    public int getItemCount() {
        return authorList.size();
    }
    static class AuthorViewHolder extends RecyclerView.ViewHolder {
        TextView tvNo, tvBookName;
        public AuthorViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNo = itemView.findViewById(R.id.tvNo);
            tvBookName = itemView.findViewById(R.id.tvBookName);

        }
    }
}