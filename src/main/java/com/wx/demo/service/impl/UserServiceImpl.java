package com.wx.demo.service.impl;

import com.wx.demo.dao.UserDao;
import com.wx.demo.entity.User;
import com.wx.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryUser() {
        return userDao.queryUser();
    }

    @Override
    public User getUserById(String userId, String userPassword) {
        return userDao.queryUserById(userId, userPassword);
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Transactional
    @Override
    public boolean updateUser(String userId, String userNickname, String userAcademy, String userQq, String userTelephone) {
                int effectedNum = userDao.updateUser(userId, userNickname, userAcademy, userQq, userTelephone);
                if (effectedNum > 0)
                    return true;
                else
                    return false;
    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }

    @Override
    public boolean updatePassword(String userId, String userPassword) {
        int effectedNum = userDao.updatePassword(userId, userPassword);
        if(effectedNum > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateUserHead(String userId, String userHead) {
        int effectedNum = userDao.updateHead(userId, userHead);
        if(effectedNum > 0)
            return true;
        else
            return false;
    }


}
