package com.example.librarymanage.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.librarymanage.DTO.AuthorDTO;
import com.example.librarymanage.DTO.BookDTO;
import com.example.librarymanage.DTO.UserDTO;

import java.util.Date;

@Entity(tableName = "borrow", foreignKeys = {@ForeignKey(
        entity = BookDTO.class, parentColumns = "readerId",
        childColumns = "readerId"), @ForeignKey(entity = AuthorDTO.class, parentColumns = "librarianId",
        childColumns = "librarianId"), @ForeignKey(entity = UserDTO.class, parentColumns = "bookId",
        childColumns = "bookId")}, indices = @Index(value="bookId")
)
public class Borrow {
    @PrimaryKey()
    private int borrowId;
    @ColumnInfo(name = "readerId")
    private int readerId;
    @ColumnInfo(name = "librarianId")
    private int librarianId;
    @ColumnInfo(name = "bookId")
    private int bookId;
    @ColumnInfo(name = "quantity")
    private int quantity;
    @ColumnInfo(name = "borrowDate")
    private Date borrowDate;
    @ColumnInfo(name = "returnDate")
    private Date returnDate;
    @ColumnInfo(name = "status")
    private int status;

}
