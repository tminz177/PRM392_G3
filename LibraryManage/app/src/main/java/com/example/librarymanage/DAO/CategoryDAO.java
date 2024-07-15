package com.example.librarymanage.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.librarymanage.Entity.Category;

import java.util.List;

@Dao
public interface CategoryDAO {
    @Query("SELECT * FROM category")
    List<Category> getcategoryList();
}
