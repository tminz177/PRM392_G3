package com.example.librarymanage;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.librarymanage.model.Author;
import com.example.librarymanage.model.Book;
import com.example.librarymanage.model.Category;
import com.example.librarymanage.model.Publisher;

@Database(entities = {Book.class, Author.class, Category.class, Publisher.class}, version = 1, exportSchema = false)
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
}
