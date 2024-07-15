package com.example.librarymanage.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.librarymanage.Entity.Author;

import java.util.List;

@Dao
public interface AuthorDAO {

    @Insert
    void insertAuthor(Author author);

    @Query("SELECT * FROM author")
    List<Author> getAuthors();

    @Query("SELECT authorId FROM author WHERE authorName = :name")
    Integer getAuthorIdByName(String name);

    @Query("SELECT MAX(authorId) FROM author")
    int getLatestAuthorId();
}
