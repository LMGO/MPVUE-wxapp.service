package com.wx.demo.dao;

import com.wx.demo.entity.User;

import java.util.List;

public interface UserDao {
    List<User> queryUser();
    User queryUserById(String userId, String userPassword);
    int insertUser(User user);
    int updateUser(String userId, String userNickname, String userAcademy, String userQq, String userTelephone);
    int deleteUser(String userId);
    int updatePassword(String userId, String userPassword);
    int updateHead(String userId, String userHead);
}
