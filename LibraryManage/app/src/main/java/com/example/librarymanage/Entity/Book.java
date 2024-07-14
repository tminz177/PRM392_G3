package com.example.librarymanage.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "book", indices = {@Index(value = "authorId", unique = true),
        @Index(value = "categoryId", unique = true), @Index(value = "publisherId", unique = true)})
public class Book {
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

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBorrowPrice() {
        return borrowPrice;
    }

    public void setBorrowPrice(int borrowPrice) {
        this.borrowPrice = borrowPrice;
    }
}
