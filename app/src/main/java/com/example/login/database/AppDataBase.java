package com.example.login.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.login.dao.UserInfoDAO;
import com.example.login.data.UserInfo;

@Database(entities = {UserInfo.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
       public abstract UserInfoDAO userInfoDAO();
}
