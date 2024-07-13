package com.example.librarymanage.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.librarymanage.Adapter.BookAdapter;
import com.example.librarymanage.DTO.BookDTO;
import com.example.librarymanage.DTO.RoomDB;
import com.example.librarymanage.Entity.*;
import com.example.librarymanage.R;

import java.util.ArrayList;
import java.util.List;

public class HomepageActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private List<Book> book = new ArrayList<>();
    private BookAdapter bookAdapter;
    private RecyclerView recyclerView;

    RoomDB database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.homepage);
        ImageSlider imageSlider;
        imageSlider = findViewById(R.id.image_slider);
        ArrayList<SlideModel> imageList = new ArrayList<>();

        imageList.add(new SlideModel(R.drawable.ic_launcher_background, ScaleTypes.FIT));

        imageSlider.setImageList(imageList);

        recyclerView = findViewById(R.id.bookRecyclerView);
        recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        );
        List<BookDTO> book = new ArrayList<>();
        recyclerView.setAdapter(new BookAdapter(HomepageActivity.this, book));
    }

}
