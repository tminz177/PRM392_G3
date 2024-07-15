package com.example.librarymanage.DAO;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.librarymanage.DTO.UserDTO;
import com.example.librarymanage.Entity.*;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert(onConflict = REPLACE)
    void insert(UserDTO user);

    @Delete
    void delete(UserDTO user);

    @Delete
    void deleteAll(List<UserDTO> users);

    @Update
    void update(UserDTO user);

//    @Query("SELECT * FROM User")
//    List<UserDTO> getAllUsers();
//
//    @Query("SELECT * FROM user WHERE userId = :userId")
//    UserDTO getUserById(int userId);
//
//    @Query("SELECT * FROM user WHERE email = :email")
//    UserDTO getUserByEmail(String email);
}
