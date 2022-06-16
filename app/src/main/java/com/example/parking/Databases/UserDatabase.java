package com.example.parking.Databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.parking.Daos.UserDao;
import com.example.parking.mvvm.models.User;

@Database(entities = {User.class},version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
public abstract UserDao getUserDao();
}
