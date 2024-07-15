package com.example.librarymanage.DTO;

import androidx.room.ColumnInfo;

public class Author {
    public int authorId;

    @ColumnInfo(name = "authorName")
    public String authorName;


    public Author() {
    }

    public Author(int authorId, String authorName) {
        this.authorId = authorId;
        this.authorName = authorName;
    }
}