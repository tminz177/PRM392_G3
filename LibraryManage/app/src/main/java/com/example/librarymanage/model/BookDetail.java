package com.example.librarymanage.model;

public class BookDetail {
    private int bookId;
    private String categoryName;
    private String authorName;
    private String publisherName;
    private String bookName;
    private String image;
    private String introduction;
    private String language;
    private int publishingYear;
    private int quantity;
    private int borrowPrice;

    public BookDetail(int bookId, String categoryName, String authorName, String publisherName,
                      String bookName, String image, String introduction, String language,
                      int publishingYear, int quantity, int borrowPrice) {
        this.bookId = bookId;
        this.categoryName = categoryName;
        this.authorName = authorName;
        this.publisherName = publisherName;
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

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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
