package com.example.librarymanage.DTO;
import java.util.Date;
public class BorrowDTO {
    private int borrowId;
    private int readerId;
    private int librarianId;
    private int bookId;
    private String quantity;
    private Date borrowDate;
    private Date returnDate;
    private int status;

    public BorrowDTO(int borrowId, int readerId, int librarianId, int bookId, String quantity, Date borrowDate, Date returnDate, int status) {
        this.borrowId = borrowId;
        this.readerId = readerId;
        this.librarianId = librarianId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
