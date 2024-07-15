package com.example.librarymanage.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librarymanage.DTO.Reader;
import com.example.librarymanage.R;

import java.util.List;
public class ReaderAdapter extends RecyclerView.Adapter<ReaderAdapter.ReaderViewHolder> {
    private List<Reader> readerList;

    public ReaderAdapter(List<Reader> readerList) {
        this.readerList = readerList;
    }

    @NonNull
    @Override
    public ReaderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reader, parent, false);
        return new ReaderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReaderViewHolder holder, int position) {
        Reader reader = readerList.get(position);
        holder.tvNo.setText(String.valueOf(position + 1));
        holder.tvReader.setText(reader.readerName);
        holder.tvEmail.setText(reader.email);
    }

    @Override
    public int getItemCount() {
        return readerList.size();
    }

    static class ReaderViewHolder extends RecyclerView.ViewHolder {
        TextView tvNo, tvReader, tvEmail;

        public ReaderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNo = itemView.findViewById(R.id.tvNo);
            tvReader = itemView.findViewById(R.id.tvReader);
            tvEmail = itemView.findViewById(R.id.tvEmail);
        }
    }
}