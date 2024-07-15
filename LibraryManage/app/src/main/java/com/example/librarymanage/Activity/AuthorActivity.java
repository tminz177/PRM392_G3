package com.example.librarymanage.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librarymanage.Adapter.AuthorAdapter;
import com.example.librarymanage.DTO.RoomDB;
import com.example.librarymanage.Entity.Author;
import com.example.librarymanage.R;

import java.util.ArrayList;
import java.util.List;

public class AuthorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AuthorAdapter authorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_author);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RoomDB db = RoomDB.getInstance(this);
//        List<Borrower> borrowList = db.borrowDAO().getBorrowedBooks();
        List<Author> authorList = new ArrayList<>();
        authorList.add(new Author(1, "What do you mean"));

        authorAdapter = new AuthorAdapter(authorList);
        recyclerView.setAdapter(authorAdapter);
    }
}
