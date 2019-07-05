package com.wx.demo.service.impl;
import com.wx.demo.dao.LostandfoundDao;
import com.wx.demo.entity.Lfcomment;
import com.wx.demo.entity.Lostandfound;
import com.wx.demo.service.LostandfoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostandfoundServiceImpl implements LostandfoundService {
    @Autowired
    private LostandfoundDao lostandfoundDao;

    @Override
    public List<Lostandfound> queryLostandfound() {
        return lostandfoundDao.queryLostandfound();
    }

    @Override
    public boolean insertLostandfound(String lfId, String lfDes, String userId, String lfTheme, String lfTime, String userNickname, String userHead) {
        int effectedNum = lostandfoundDao.insertLostandfound(lfId, lfDes, userId, lfTheme, lfTime, userNickname, userHead);
        if(effectedNum > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteLostandfound(String lfId) {
        int effectedNum = lostandfoundDao.deleteLostandfound(lfId);
        if(effectedNum > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean insertPicture(String lfId) {
        return false;
    }

    @Override
    public boolean insertComment(String lfcommentId, String userId, String userNickname, String lfcommentContent, String lfId) {
        int effectedNum = lostandfoundDao.insertComment(lfcommentId, userId, userNickname, lfcommentContent, lfId);
        if(effectedNum > 0)
            return true;
        else
            return false;
    }

    @Override
    public List<Lfcomment> queryComment(String lfId) {
        return lostandfoundDao.queryComment(lfId);
    }

    @Override
    public List<Lostandfound> queryMy(String userId) {
        return lostandfoundDao.queryMy(userId);
    }

    @Override
    public int queryCommentcount(String lfId) {
        return lostandfoundDao.queryCommentcount(lfId);
    }

    @Override
    public boolean updateFound(String lfId) {
        int effectedNum = lostandfoundDao.updateFound(lfId);
        if(effectedNum > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateNotfound(String lfId) {
        int effectedNum = lostandfoundDao.updateNotfound(lfId);
        if(effectedNum > 0)
            return true;
        else
            return false;
    }
}
