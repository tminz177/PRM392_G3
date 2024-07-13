package com.example.librarymanage.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;

    @Entity(tableName = "book", indices = {@Index(value = "authorId", unique = true),
            @Index(value = "categoryId", unique = true), @Index(value = "publisherId", unique = true)})
    public class Book{
        @NonNull
        @PrimaryKey(autoGenerate = true)
        private int bookId;

        @ColumnInfo(name = "categoryId")
        private int categoryId;

        @ColumnInfo(name = "authorId")
        private int authorId;

        @ColumnInfo(name = "publisherId")
        private int publisherId;

        @ColumnInfo(name = "bookName")
        private String bookName;

        @ColumnInfo(name = "image")
        private String image;

        @ColumnInfo(name = "introduction")
        private String introduction;

        @ColumnInfo(name = "language")
        private String language;

        @ColumnInfo(name = "publishingYear")
        private int publishingYear;

        @ColumnInfo(name = "quantity")
        private int quantity;

        @ColumnInfo(name = "borrowPrice")
        private int borrowPrice;
    }
