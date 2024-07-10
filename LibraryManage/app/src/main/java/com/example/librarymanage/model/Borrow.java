package com.example.librarymanage.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(tableName = "borrow", foreignKeys = {@ForeignKey(
        entity = Book.class, parentColumns = "bookId",
        childColumns = "bookId"), @ForeignKey(entity = Author.class, parentColumns = "authorId",
        childColumns = "authorId"), @ForeignKey(entity = User.class, parentColumns = "userId",
        childColumns = "readerId"), @ForeignKey(entity = User.class, parentColumns = "userId",
        childColumns = "librarianId")}, indices = @Index(value="bookId")
)
public class Borrow {
}
