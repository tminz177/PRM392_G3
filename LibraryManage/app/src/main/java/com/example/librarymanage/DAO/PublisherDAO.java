package com.example.librarymanage.DAO;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.librarymanage.Entity.Publisher;

import java.util.List;

@Dao
public interface PublisherDAO {

    @Insert
    void insertPublisher(Publisher publisher);

    @Query("SELECT * FROM publisher")
    List<Publisher> getPublishers();

    @Query("SELECT publisherId FROM publisher WHERE publisherName = :name")
    Integer getPublisherIdByName(String name);

    @Query("SELECT MAX(publisherId) FROM publisher")
    int getLatestPublisherId();
}
