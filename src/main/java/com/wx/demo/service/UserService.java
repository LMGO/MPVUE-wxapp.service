package com.wx.demo.service;

import com.wx.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> queryUser();
    User getUserById(String userId, String userPassword);
    boolean addUser(User user);
    boolean updateUser(String userId, String userNickname, String userAcademy, String userQq, String userTelephone);
    boolean deleteUser(String userId);
    boolean updatePassword(String userId, String userPassword);
    boolean updateUserHead(String userId, String userHead);
}
