package com.example.librarymanage.Repository;

import android.content.Context;

import com.example.librarymanage.DAO.BookDAO;
import com.example.librarymanage.DTO.RoomDB;
import com.example.librarymanage.Entity.Book;

public class BookRepository {

    private final BookDAO bookDAO;

    public BookRepository(Context context) {
        RoomDB roomDB = RoomDB.getInstance(context);
        bookDAO = roomDB.bookDAO();
    }

    public void createBook(Book book) {
        bookDAO.insert(book);
    }

}
