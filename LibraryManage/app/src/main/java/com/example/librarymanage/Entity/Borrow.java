package com.example.librarymanage.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.librarymanage.Converter.Converter;


import java.util.Date;

@Entity(tableName = "borrow", foreignKeys = {@ForeignKey(
        entity = User.class, parentColumns = "userId",
        childColumns = "readerId"), @ForeignKey(entity = User.class, parentColumns = "userId",
        childColumns = "librarianId"), @ForeignKey(entity = Book.class, parentColumns = "bookId",
        childColumns = "bookId")}, indices = {@Index(value="bookId"), @Index(value="readerId"), @Index(value="librarianId")}
)
@TypeConverters(Converter.class)
public class Borrow {
    @PrimaryKey()
    public int borrowId;
    @ColumnInfo(name = "readerId")
    public int readerId;
    @ColumnInfo(name = "librarianId")
    public int librarianId;
    @ColumnInfo(name = "bookId")
    public int bookId;
    @ColumnInfo(name = "quantity")
    public int quantity;
    @ColumnInfo(name = "borrowDate")
    public Date borrowDate;
    @ColumnInfo(name = "returnDate")
    public Date returnDate;
    @ColumnInfo(name = "status")
    public int status;

}
