package com.example.librarymanage.DAO;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.librarymanage.Entity.*;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert(onConflict = REPLACE)
    void insert(User user);

    @Delete
    void delete(User user);

    @Delete
    void deleteAll(List<User> user);

    @Update
    void update(User user);

    @Query("SELECT * FROM User")
    List<User> getAllUsers();

    @Query("SELECT * FROM user WHERE userId = :userId")
    User getUserById(int userId);

    @Query("SELECT * FROM user WHERE email = :email")
    User getUserByEmail(String email);
}
