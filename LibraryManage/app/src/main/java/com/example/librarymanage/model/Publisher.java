package com.example.librarymanage.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "publisher", foreignKeys = @ForeignKey(
        entity= Book.class, parentColumns = "publisherId",
        childColumns = "publisherId"),
        indices = @Index(value="publisherId")
)
public class Publisher {
    @PrimaryKey(autoGenerate = true)
    private int publisherId;

    @ColumnInfo(name = "publisherName")
    private String publisherName;

    public Publisher(@NonNull int publisherId, String publisherName) {
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