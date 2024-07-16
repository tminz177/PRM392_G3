package com.example.librarymanage.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.librarymanage.Adapter.BookAdapter;
import com.example.librarymanage.DAO.AuthorDAO;
import com.example.librarymanage.DAO.BookDAO;
import com.example.librarymanage.DTO.RoomDB;
import com.example.librarymanage.Entity.*;
import com.example.librarymanage.R;

import java.util.ArrayList;
import java.util.List;

public class HomepageActivity extends AppCompatActivity {
    private BookAdapter bookAdapter;
    private RecyclerView recyclerView;
    private RoomDB roomDB;
    private BookDAO bookDao;
    private AuthorDAO authorDao;

    RoomDB database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        loadImageSlider();
        getRoomData();
    }

    public void getRoomData(){
        roomDB = RoomDB.getInstance(this);
        bookDao = roomDB.bookDAO();
        authorDao = roomDB.authorDAO();

        recyclerView = findViewById(R.id.bookRecyclerView);
        recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        );

        List<Book> bookList = bookDao.getBookList();
        List<Author> authorList = authorDao.getAuthorList();

        recyclerView.setAdapter(new BookAdapter(HomepageActivity.this, bookList, authorList));
    }

    public void loadImageSlider(){
        ImageSlider imageSlider = findViewById(R.id.image_slider);
        ArrayList<SlideModel> imageList = new ArrayList<>();

        imageList.add(new SlideModel(R.drawable.ic_launcher_background, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.side_nav_bar, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.search_background, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.ic_launcher_background, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.ic_launcher_background, ScaleTypes.FIT));

        imageSlider.setImageList(imageList, ScaleTypes.FIT);
    }

}
