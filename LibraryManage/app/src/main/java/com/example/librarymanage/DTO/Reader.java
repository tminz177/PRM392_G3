package com.example.librarymanage.DTO;

import androidx.room.ColumnInfo;

public class Reader {
    public int readerId;

    @ColumnInfo(name = "reader name")
    public String readerName;

    @ColumnInfo(name = "email")
    public String email;

    public Reader() {
    }

    public Reader(int readerId, String readerName, String email) {
        this.readerId = readerId;
        this.readerName = readerName;
        this.email = email;
    }
}
