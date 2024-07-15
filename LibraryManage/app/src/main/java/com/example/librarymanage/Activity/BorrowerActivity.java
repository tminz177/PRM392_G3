package com.example.librarymanage.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librarymanage.Adapter.BorrowAdapter;
import com.example.librarymanage.DTO.Borrower;
import com.example.librarymanage.DTO.RoomDB;
import com.example.librarymanage.R;

import java.util.ArrayList;
import java.util.List;

public class BorrowerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BorrowAdapter borrowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_borrower);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RoomDB db = RoomDB.getInstance(this);
//        List<Borrower> borrowList = db.borrowDAO().getBorrowedBooks();
        List<Borrower> borrowList = new ArrayList<>();
        borrowList.add(new Borrower(1, "What do you mean", "test"));
        borrowList.add(new Borrower(2, "What do you want", "test"));

        borrowAdapter = new BorrowAdapter(borrowList);
        recyclerView.setAdapter(borrowAdapter);
    }
}