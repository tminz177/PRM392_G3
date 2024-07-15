package com.example.librarymanage.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librarymanage.DTO.Borrower;
import com.example.librarymanage.R;

import java.util.List;

public class BorrowAdapter extends RecyclerView.Adapter<BorrowAdapter.BorrowViewHolder> {
    private List<Borrower> borrowList;

    public BorrowAdapter(List<Borrower> borrowList) {
        this.borrowList = borrowList;
    }

    @NonNull
    @Override
    public BorrowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_borrower, parent, false);
        return new BorrowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BorrowViewHolder holder, int position) {
        Borrower borrow = borrowList.get(position);
        holder.tvNo.setText(String.valueOf(position + 1));
        holder.tvBookName.setText(borrow.bookName);
        holder.tvBorrower.setText(borrow.borrower);
    }

    @Override
    public int getItemCount() {
        return borrowList.size();
    }

    static class BorrowViewHolder extends RecyclerView.ViewHolder {
        TextView tvNo, tvBookName, tvBorrower;

        public BorrowViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNo = itemView.findViewById(R.id.tvNo);
            tvBookName = itemView.findViewById(R.id.tvBookName);
            tvBorrower = itemView.findViewById(R.id.tvBorrower);
        }
    }
}

