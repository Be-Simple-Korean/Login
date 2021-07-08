package com.example.login.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.login.data.UserInfo;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface UserInfoDAO {
    @Query("Select * from UserInfo where id =:id and pwd=:pwd")
    boolean isUser(String id,String pwd);

    @Query("Select * from UserInfo")
    List<UserInfo> getAll();

    @Insert
    void insert(UserInfo userInfoVO);
}
