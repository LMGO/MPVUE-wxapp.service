package com.wx.demo.dao;

import com.wx.demo.entity.Wespace;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WespaceDaoTest {
    @Autowired
    private WespaceDao wespaceDao;

    @Test
    @Ignore
    public void queryWespace() {
        List<Wespace> wespaceList = wespaceDao.queryWespace();
        assertEquals(2, wespaceList.size());
    }

    @Test
    @Ignore
    public void deleteWespace() {
        assertEquals(1, wespaceDao.deleteWespace("3"));
    }

//    @Test
//    @Ignore
//    public void insertWespace() {
//        Date microTime = java.sql.Date.valueOf("2019-6-24");
//        SimpleDateFormat df = new SimpleDateFormat(("yyyy-MM--dd HH:mm:ss"));
//        String microId = df.format(new Date());
//        assertEquals(1, wespaceDao.insertWespace(microId, "555", "第三条微空间", "20171120301", microTime, "大磊"));
//    }

    @Test
    @Ignore
    public void upWespace() {
        assertEquals(1, wespaceDao.upWespace("1"));
    }
}