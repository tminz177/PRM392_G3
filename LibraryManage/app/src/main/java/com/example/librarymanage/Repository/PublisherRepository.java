package com.example.librarymanage.Repository;

import android.content.Context;

import com.example.librarymanage.DAO.PublisherDAO;
import com.example.librarymanage.DTO.RoomDB;
import com.example.librarymanage.Entity.Publisher;

import java.util.List;

public class PublisherRepository {
    private final PublisherDAO publisherDAO;

    public PublisherRepository(Context context) {
        RoomDB roomDB = RoomDB.getInstance(context);
        publisherDAO = roomDB.publisherDAO();
    }

    public void insert(Publisher publisher) {
        publisherDAO.insertPublisher(publisher);
    }

    public List<Publisher> getPublishers() {
        return publisherDAO.getPublishers();
    }

    public Integer getPublisherIdByName(String name) {
        return publisherDAO.getPublisherIdByName(name);
    }

    public int getLatestPublisherId() {
        return publisherDAO.getLatestPublisherId();
    }
}
