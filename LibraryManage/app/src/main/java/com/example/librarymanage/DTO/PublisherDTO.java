package com.example.librarymanage.DTO;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "publisher", foreignKeys = @ForeignKey(
        entity= BookDTO.class, parentColumns = "publisherId",
        childColumns = "publisherId"),
        indices = @Index(value="publisherId")
)
public class PublisherDTO {
    @PrimaryKey(autoGenerate = true)
    private int publisherId;

    @ColumnInfo(name = "publisherName")
    private String publisherName;

    public PublisherDTO(@NonNull int publisherId, String publisherName) {
        this.publisherId = publisherId;
        this.publisherName = publisherName;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }
}