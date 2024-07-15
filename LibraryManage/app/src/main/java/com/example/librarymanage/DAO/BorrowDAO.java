package com.example.librarymanage.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.librarymanage.DTO.Borrower;

import java.util.List;

@Dao
public interface BorrowDAO {

    @Query("SELECT borrow.borrowId, book.bookName, user.fullname AS borrower " +
            "FROM borrow " +
            "INNER JOIN book ON borrow.bookId = book.bookId " +
            "INNER JOIN user ON borrow.readerId = user.userId")
    List<Borrower> getBorrowedBooks();
}
