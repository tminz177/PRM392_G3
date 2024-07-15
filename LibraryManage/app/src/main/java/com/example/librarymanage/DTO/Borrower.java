package com.example.librarymanage.DTO;

import androidx.room.ColumnInfo;

public class Borrower {

    public int borrowId;

    @ColumnInfo(name = "bookName")
    public String bookName;

    @ColumnInfo(name = "borrower")
    public String borrower;

    public Borrower() {
    }

    public Borrower(int borrowId, String bookName, String borrower) {
        this.borrowId = borrowId;
        this.bookName = bookName;
        this.borrower = borrower;
    }
}
