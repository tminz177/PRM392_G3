package com.example.librarymanage.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librarymanage.Adapter.PublisherAdapter;
import com.example.librarymanage.DTO.RoomDB;
import com.example.librarymanage.Entity.Publisher;
import com.example.librarymanage.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPublisher extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PublisherAdapter publisherAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.view_publisherlist);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RoomDB db = RoomDB.getInstance(this);
      //  List<Publisher> publishers = db.publisherDAO().getPublishers();
        List<Publisher> publisherList = new ArrayList<>();
//        publisherList.add(new PublisherDTO(1, "What do you mean"));
//        publisherList.add(new PublisherDTO(2, "What do you want"));

        publisherAdapter = new PublisherAdapter(publisherList);
        recyclerView.setAdapter(publisherAdapter);
    }
}
