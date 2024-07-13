package com.example.librarymanage.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.librarymanage.DTO.BookDTO;

@Entity(tableName = "author", foreignKeys = @ForeignKey(
        entity= BookDTO.class, parentColumns = "authorId",
        childColumns = "authorId"),
        indices = @Index(value="authorId")
)
public class Author {
    @PrimaryKey(autoGenerate = true)
    private int authorId;

    @ColumnInfo(name = "authorName")
    private String authorName;
}
