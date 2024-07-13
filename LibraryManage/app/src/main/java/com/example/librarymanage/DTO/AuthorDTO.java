package com.example.librarymanage.DTO;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "author", foreignKeys = @ForeignKey(
        entity= BookDTO.class, parentColumns = "authorId",
        childColumns = "authorId"),
        indices = @Index(value="authorId")
)
public class AuthorDTO {
    @PrimaryKey(autoGenerate = true)
    private int authorId;

    @ColumnInfo(name = "authorName")
    private String authorName;

    public AuthorDTO(@NonNull int authorId, String authorName) {
        this.authorId = authorId;
        this.authorName = authorName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}