package com.example.librarymanage.DTO;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "category", foreignKeys = @ForeignKey(
        entity= BookDTO.class, parentColumns = "categoryId",
        childColumns = "categoryId"),
        indices = @Index(value="categoryId")
)
public class CategoryDTO {
    @PrimaryKey(autoGenerate = true)
    private int categoryId;

    @ColumnInfo(name = "categoryName")
    private String categoryName;

    public CategoryDTO(@NonNull int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}