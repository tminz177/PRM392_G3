package com.example.librarymanage.Entity;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.librarymanage.DTO.BookDTO;

@Entity(tableName = "publisher", foreignKeys = @ForeignKey(
        entity= BookDTO.class, parentColumns = "publisherId",
        childColumns = "publisherId"),
        indices = @Index(value="publisherId")
)
public class Publisher {
    @PrimaryKey(autoGenerate = true)
    private int publisherId;

    @ColumnInfo(name = "publisherName")
    private String publisherName;

}
