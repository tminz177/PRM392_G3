package com.example.librarymanage.Entity;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.librarymanage.DTO.BookDTO;

@Entity(tableName = "publisher", foreignKeys = @ForeignKey(
        entity= Book.class, parentColumns = "publisherId",
        childColumns = "publisherId"),
        indices = @Index(value="publisherId")
)
public class Publisher {
    @PrimaryKey(autoGenerate = true)
    public int publisherId;

    @ColumnInfo(name = "publisherName")
    public String publisherName;


    public Publisher() {
    }

    public Publisher(int publisherId, String publisherName) {
        this.publisherId = publisherId;
        this.publisherName = publisherName;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

}
