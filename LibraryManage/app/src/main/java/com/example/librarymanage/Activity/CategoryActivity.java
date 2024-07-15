package com.example.librarymanage.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librarymanage.Adapter.CategoryAdapter;
import com.example.librarymanage.DTO.RoomDB;
import com.example.librarymanage.Entity.Category;
import com.example.librarymanage.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RoomDB db = RoomDB.getInstance(this);
//        List<Borrower> borrowList = db.borrowDAO().getBorrowedBooks();
        List<Category> categoryList = new ArrayList<>();
//        categoryList.add(new CategoryDTO(1, "What do you mean"));
//        categoryList.add(new CategoryDTO(2, "sdas"));

        categoryAdapter = new CategoryAdapter(categoryList);
        recyclerView.setAdapter(categoryAdapter);
    }
}