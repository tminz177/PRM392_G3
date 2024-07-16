package com.example.librarymanage.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;

import com.example.librarymanage.Entity.Book;

import java.util.List;

@Dao
public interface BookDAO {

    @Insert(onConflict = REPLACE)
    void insert(Book book);

    @Delete
    void delete(Book book);

    @Delete
    void reset(List<Book> book);

    @Query("UPDATE book SET bookName = :sName, image = :sImage, introduction = :sIntroduction, " +
            "publishingYear = :sPublishingYear, quantity = :sQuantity, " +
            "borrowPrice = :sBorrowPrice WHERE bookId = :sID")
    void update(int sID, String sName, String sImage, String sIntroduction,
                int sPublishingYear, int sQuantity, int sBorrowPrice);

    @Query("UPDATE book SET quantity = :sQuantity WHERE bookId = :sID")
    void updateQuantity(int sID, int sQuantity);

    @Query("SELECT * FROM book b join author a on b.authorId = a.authorId")
    List<Book> getBookList();
}
