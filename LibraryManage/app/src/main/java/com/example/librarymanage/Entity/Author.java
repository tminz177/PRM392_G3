package com.example.librarymanage.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.librarymanage.DTO.BookDTO;

@Entity(tableName = "author", foreignKeys = @ForeignKey(
        entity= Book.class, parentColumns = "authorId",
        childColumns = "authorId"),
        indices = @Index(value="authorId")
)
public class Author {
    @PrimaryKey(autoGenerate = true)
    public int authorId;

    @ColumnInfo(name = "authorName")
    public String authorName;

    @ColumnInfo(name = "authorImage")
    public String authorImage;


}
