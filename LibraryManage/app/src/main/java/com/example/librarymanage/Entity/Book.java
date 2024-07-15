package com.example.librarymanage.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "book", indices = {@Index(value = "authorId", unique = true),
        @Index(value = "categoryId", unique = true), @Index(value = "publisherId", unique = true)})
public class Book{
    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int bookId;

    @ColumnInfo(name = "categoryId")
    public int categoryId;

    @ColumnInfo(name = "authorId")
    public int authorId;

    @ColumnInfo(name = "publisherId")
    public int publisherId;

    @ColumnInfo(name = "bookName")
    public String bookName;

    @ColumnInfo(name = "image")
    public String image;

    @ColumnInfo(name = "introduction")
    public String introduction;

    @ColumnInfo(name = "publishingYear")
    public int publishingYear;

    @ColumnInfo(name = "quantity")
    public int quantity;

    @ColumnInfo(name = "borrowPrice")
    public int borrowPrice;


    public Book(int categoryId, int authorId, int publisherId, String bookName, String image, String introduction, int publishingYear, int quantity, int borrowPrice) {
        this.categoryId = categoryId;
        this.authorId = authorId;
        this.publisherId = publisherId;
        this.bookName = bookName;
        this.image = image;
        this.introduction = introduction;
        this.publishingYear = publishingYear;
        this.quantity = quantity;
        this.borrowPrice = borrowPrice;
    }

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

    public double getBorrowPrice() {
        return borrowPrice;
    }

    public void setBorrowPrice(int borrowPrice) {
        this.borrowPrice = borrowPrice;
    }
}