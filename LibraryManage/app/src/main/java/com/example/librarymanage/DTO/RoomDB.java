package com.example.librarymanage.DTO;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.librarymanage.DAO.AuthorDAO;
import com.example.librarymanage.DAO.BookDAO;
import com.example.librarymanage.DAO.BorrowDAO;
import com.example.librarymanage.DAO.CategoryDAO;
import com.example.librarymanage.DAO.PublisherDAO;
import com.example.librarymanage.DAO.UserDAO;
import com.example.librarymanage.Entity.Author;
import com.example.librarymanage.Entity.Book;
import com.example.librarymanage.Entity.Category;
import com.example.librarymanage.Entity.Publisher;
import com.example.librarymanage.Entity.User;

@Database(entities = {Book.class, Author.class, Category.class, Publisher.class, User.class}, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    private static RoomDB database;

    private static String DATABASE_NAME = "database";

    public synchronized static RoomDB getInstance(Context context){
        if(database == null){
            database = Room.databaseBuilder(context.getApplicationContext(),
                    RoomDB.class, DATABASE_NAME).allowMainThreadQueries()
                    .fallbackToDestructiveMigration().build();
        }
        return database;
    }

    public abstract BookDAO bookDAO();
    public abstract AuthorDAO authorDAO();
    public abstract BorrowDAO borrowDAO();
    public abstract CategoryDAO categoryDAO();
    public abstract PublisherDAO publisherDAO();
    public abstract UserDAO userDAO();
}
