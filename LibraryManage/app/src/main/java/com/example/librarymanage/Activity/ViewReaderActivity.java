package com.example.librarymanage.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librarymanage.Adapter.ReaderAdapter;
import com.example.librarymanage.DTO.Reader;
import com.example.librarymanage.DTO.RoomDB;
import com.example.librarymanage.R;

import java.util.ArrayList;
import java.util.List;

public class ViewReaderActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ReaderAdapter readerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.view_readerlist);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RoomDB db = RoomDB.getInstance(this);
//        List<Reader> readersList = db.userDAO().getAllUsers();
        List<Reader> readerLists = new ArrayList<>();
        readerLists.add(new Reader(1, "What do you want", "test"));
        readerLists.add(new Reader(2, "What do you want", "test"));

        readerAdapter = new ReaderAdapter(readerLists);
       recyclerView.setAdapter(readerAdapter);
    }
}
