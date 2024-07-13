package com.example.librarymanage.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;

import com.example.librarymanage.Entity.*;

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
            "language = :sLanguage, publishingYear = :sPublishingYear, quantity = :sQuantity, " +
            "borrowPrice = :sBorrowPrice WHERE bookId = :sID")
    void update(int sID, String sName, String sImage, String sIntroduction, String sLanguage,
                int sPublishingYear, int sQuantity, int sBorrowPrice);

    @Query("UPDATE book SET quantity = :sQuantity WHERE bookId = :sID")
    void updateQuantity(int sID, int sQuantity);

    @Query("SELECT book.bookId, category.categoryName, author.authorName, publisher.publisherName, book.bookName, book.image," +
            "book.introduction, book.language, book.publishingYear, book.quantity, book.borrowPrice" +
            " FROM book join author on book.authorId = author.authorId join category on book.categoryId = category.categoryId " +
            "join publisher on book.publisherId = publisher.publisherId")
    List<Book> getAll();

    @Query("SELECT * FROM Book")
    List<Book> getBookList();
}
