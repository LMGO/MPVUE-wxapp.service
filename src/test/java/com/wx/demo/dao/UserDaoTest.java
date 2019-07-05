package com.wx.demo.dao;

import com.wx.demo.entity.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    @Ignore
    public void queryUser() {
        List<User> userList = userDao.queryUser();
        assertEquals(1, userList.size());
    }

    @Test
    @Ignore
    public void queryUserById() {
        User user = userDao.queryUserById("20171120301", "123456789");
        assertEquals("李岳哲", user.getUserName());
    }

    @Test
    @Ignore
    public void insertUser() {
    }

    @Test
    public void updateUser() {
//        User user = new User();
//        user.setUserId("20171120301");
//        user.setUserNickname("小磊");
//        user.setUserQq("1114100345");
//        user.setUserTelephone("18687251007");
//        user.setUserAcademy("software engineering");
//        int effectedNum = userDao.updateUser(user);
//        assertEquals(1, effectedNum);
        int effectNum = userDao.updateUser("20171120301", "小磊", "软件学院", "1114100345", "18687251007");
        assertEquals(1, effectNum);
    }

    @Test
    @Ignore
    public void deleteUser() {
    }

    @Test
    @Ignore
    public void updatePassword() {
//        User user = new User();
//        user.setUserPassword("123456");
//        user.setUserId("20171120301");
        int effectedNum = userDao.updatePassword("20171120301", "1234567");
        assertEquals(1, effectedNum);
    }
}