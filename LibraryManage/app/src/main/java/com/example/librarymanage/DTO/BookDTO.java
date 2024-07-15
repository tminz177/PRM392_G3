package com.example.librarymanage.DTO;

public class BookDTO{
    private int bookId;
    private int categoryId;
    private int authorId;
    private int publisherId;
    private String bookName;
    private String image;
    private String introduction;
    private String language;
    private int publishingYear;
    private int quantity;
    private double borrowPrice;

    public BookDTO(int bookId, int categoryId, int authorId, int publisherId, String bookName,
                   String image, String introduction, String language, int publishingYear, int quantity, double borrowPrice) {
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

    public double getBorrowPrice() {
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
