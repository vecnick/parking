package com.example.parking.Daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.parking.mvvm.models.User;

import java.util.List;

@Dao
public interface UserDao {
    // Добавление User в бд
    @Insert
    void insertAll(User... people);

    // Удаление User из бд
    @Delete
    void delete(User user);

    // Получение всех User из бд
    @Query("SELECT * FROM user")
    List<User> getAllPeople();

    // Получение всех User из бд с условием
    @Query("SELECT * FROM user WHERE car LIKE :car")
    List<User> getAllPeopleWithCar(String car);
}
