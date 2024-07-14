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
            "language = :sLanguage, publishingYear = :sPublishingYear, quantity = :sQuantity, " +
            "borrowPrice = :sBorrowPrice WHERE bookId = :sID")
    void update(int sID, String sName, String sImage, String sIntroduction, String sLanguage,
                int sPublishingYear, int sQuantity, int sBorrowPrice);

    @Query("UPDATE book SET quantity = :sQuantity WHERE bookId = :sID")
    void updateQuantity(int sID, int sQuantity);

    @Query("SELECT b.bookId, b.categoryId, b.authorId, b.publisherId, " +
            "c.categoryName, a.authorName, p.publisherName, " +
            "b.bookName, b.image, b.introduction, b.language, " +
            "b.publishingYear, b.quantity, b.borrowPrice " +
            "FROM book b " +
            "INNER JOIN category c ON b.categoryId = c.categoryId " +
            "INNER JOIN author a ON b.authorId = a.authorId " +
            "INNER JOIN publisher p ON b.publisherId = p.publisherId")
    List<Book> getAll();

    @Query("SELECT * FROM Book")
    List<Book> getBookList();
}
