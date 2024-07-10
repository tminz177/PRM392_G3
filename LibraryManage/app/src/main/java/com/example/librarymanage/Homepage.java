package com.example.librarymanage;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.librarymanage.model.BookDetail;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private List<BookDetail> book = new ArrayList<>();
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

        recyclerView = findViewById(R.id.booksRecyclerView);
        recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        );
        List<BookDetail> book = new ArrayList<>();
        recyclerView.setAdapter(new BookAdapter(Homepage.this, book));
    }

}
