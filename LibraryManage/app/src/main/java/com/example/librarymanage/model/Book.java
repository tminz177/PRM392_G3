package com.example.librarymanage.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "book", indices = {@Index(value = "authorId", unique = true),
        @Index(value = "categoryId", unique = true), @Index(value = "publisherId", unique = true)})
public class Book implements Serializable {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int bookId;

    @ColumnInfo(name = "categoryId")
    private int categoryId;

    @ColumnInfo(name = "authorId")
    private int authorId;

    @ColumnInfo(name = "publisherId")
    private int publisherId;

    @ColumnInfo(name = "bookName")
    private String bookName;

    @ColumnInfo(name = "image")
    private String image;

    @ColumnInfo(name = "introduction")
    private String introduction;

    @ColumnInfo(name = "language")
    private String language;

    @ColumnInfo(name = "publishingYear")
    private int publishingYear;

    @ColumnInfo(name = "quantity")
    private int quantity;

    @ColumnInfo(name = "borrowPrice")
    private int borrowPrice;

    public Book(int bookId, int categoryId, int authorId, int publisherId, String bookName,
                String image, String introduction, String language, int publishingYear, int quantity, int borrowPrice) {
        this.bookId = bookId;
        this.categoryId = categoryId;
        this.authorId = authorId;
        this.publisherId = publisherId;
        this.bookName = bookName;
        this.image = image;
        this.introduction = introduction;
        this.language = language;
        this.publishingYear = publishingYear;
        this.quantity = quantity;
        this.borrowPrice = borrowPrice;
    }

    public int getBookId() {
        return bookId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getImage() {
        return image;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getLanguage() {
        return language;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getBorrowPrice() {
        return borrowPrice;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setBorrowPrice(int borrowPrice) {
        this.borrowPrice = borrowPrice;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }
}
