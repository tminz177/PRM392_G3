package com.example.librarymanage.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librarymanage.Entity.Publisher;
import com.example.librarymanage.R;

import java.util.List;
public class PublisherAdapter extends RecyclerView.Adapter<PublisherAdapter.PublisherViewHolder> {
    private List<Publisher> publisherList;

    public PublisherAdapter(List<Publisher> readerList) {
        this.publisherList = readerList;
    }

    @NonNull
    @Override
    public PublisherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_publisher, parent, false);
        return new PublisherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PublisherViewHolder holder, int position) {
        Publisher publisher = publisherList.get(position);
        holder.tvNo.setText(String.valueOf(position + 1));
        holder.tvPublisher.setText(publisher.publisherName);
    }

    @Override
    public int getItemCount() {
        return publisherList.size();
    }

    static class PublisherViewHolder extends RecyclerView.ViewHolder {
        TextView tvNo, tvPublisher;

        public PublisherViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNo = itemView.findViewById(R.id.tvNo);
            tvPublisher = itemView.findViewById(R.id.tvPublisher);
        }
    }
}
