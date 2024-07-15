package com.example.librarymanage.Repository;

import android.content.Context;

import com.example.librarymanage.DAO.AuthorDAO;
import com.example.librarymanage.DTO.RoomDB;
import com.example.librarymanage.Entity.Author;

import java.util.List;

public class AuthorRepository {

    private final AuthorDAO authorDAO;

    public AuthorRepository(Context context) {
        RoomDB roomDB = RoomDB.getInstance(context);
        authorDAO = roomDB.authorDAO();
    }

    public void insert(Author author) {
        authorDAO.insertAuthor(author);
    }

    public List<Author> getAuthors() {
        return authorDAO.getAuthors();
    }

    public Integer getAuthorIdByName(String name) {
        return authorDAO.getAuthorIdByName(name);
    }

    public int getLatestAuthorId() {
        return authorDAO.getLatestAuthorId();
    }
}
