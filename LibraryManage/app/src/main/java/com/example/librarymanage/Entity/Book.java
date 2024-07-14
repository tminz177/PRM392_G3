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
    public int bookId;

    @ColumnInfo(name = "categoryId")
    public int categoryId;

    @ColumnInfo(name = "authorId")
    public int authorId;

    @ColumnInfo(name = "publisherId")
    public int publisherId;

    @ColumnInfo(name = "bookName")
    public String bookName;

    @ColumnInfo(name = "image")
    public String image;

    @ColumnInfo(name = "introduction")
    public String introduction;

    @ColumnInfo(name = "language")
    public String language;

    @ColumnInfo(name = "publishingYear")
    public int publishingYear;

    @ColumnInfo(name = "quantity")
    public int quantity;

    @ColumnInfo(name = "borrowPrice")
    public int borrowPrice;
}