package com.example.librarymanage.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.librarymanage.DTO.BookDTO;

@Entity(tableName = "category", foreignKeys = @ForeignKey(
        entity= Book.class, parentColumns = "categoryId",
        childColumns = "categoryId"),
        indices = @Index(value="categoryId")
)
public class Category {
    @PrimaryKey(autoGenerate = true)
    public int categoryId;

    @ColumnInfo(name = "categoryName")
    public String categoryName;
}