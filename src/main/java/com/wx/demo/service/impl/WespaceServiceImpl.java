package com.wx.demo.service.impl;

import com.wx.demo.dao.WespaceDao;
import com.wx.demo.entity.Wecomment;
import com.wx.demo.entity.Wespace;
import com.wx.demo.entity.Weup;
import com.wx.demo.service.WespaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class WespaceServiceImpl implements WespaceService {
    @Autowired
    private WespaceDao wespaceDao;

    @Override
    public List<Wespace> queryWespace() {
        return wespaceDao.queryWespace();
    }

    @Override
    public List<Weup> queryUp(String userId) {
        return wespaceDao.queryUp(userId);
    }

//    @Override
//    public User getUserById(String userId, String userPassword) {
//        return userDao.queryUserById(userId, userPassword);
//    }

    @Override
    public boolean insertWespace(String microId, String microDes, String userId, String microTime, String userNickname, String userHead) {
        int effectedNum = wespaceDao.insertWespace(microId, microDes, userId, microTime, userNickname, userHead);
        if(effectedNum > 0)
            return true;
        else
            return false;
    }

//    @Transactional
//    @Override
//    public boolean updateUser(User user) {
//        if(user.getUserId() != null && user.getUserId().length() == 11){
//            try {
//                int effectedNum = userDao.updateUser(user);
//                if (effectedNum > 0) {
//                    return true;
//                } else {
//                    throw new RuntimeException("更新用户信息失败！");
//                }
//            }catch (Exception e){
//                throw new RuntimeException("更新用户信息失败：" + e.toString());
//            }
//        }else {
//            throw new RuntimeException("请传入用户ID！");
//        }
//    }

    @Override
    public boolean deleteWespace(String microId) {
        int effectedNum = wespaceDao.deleteWespace(microId) + wespaceDao.deleteUserup(microId);
        if(effectedNum > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean upWespace(String microId, String userId){
        int upYes = 1;
        int effectedNum = wespaceDao.upWespace(microId) + wespaceDao.insertUp(microId, userId, upYes);
        if(effectedNum > 1)
            return true;
        else
            return false;
    }

    @Override
    public boolean downWespace(String microId, String userId){
        int effectedNum = wespaceDao.downWespace(microId) + wespaceDao.deleteUp(microId, userId);
        if(effectedNum > 1)
            return true;
        else
            return false;
    }

    @Override
    public boolean insertComment(String wecommentId, String userId, String userNickname, String wecommentContent, String microId) {
        int effectedNum = wespaceDao.insertComment(wecommentId, userId, userNickname, wecommentContent, microId);
        if(effectedNum > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean upJudge(String microId, String userId) {
        if(wespaceDao.upJudge(microId, userId).size()>0)
            return true;
        else
            return false;
    }

    @Override
    public  List<Wecomment> queryComment(String microId) {
        return wespaceDao.queryComment(microId);
    }

    @Override
    public List<Wespace> queryHot() {
        return wespaceDao.queryHot();
    }

    @Override
    public List<Wespace> queryMy(String userId) {
        return wespaceDao.queryMy(userId);
    }

    @Override
    public int queryCommentcount(String microId) {
        return wespaceDao.queryCommentcount(microId);
    }
//
//    @Override
//    public boolean updatePassword(String userId, String userPassword) {
//        int effectedNum = userDao.updatePassword(userId, userPassword);
//        if(effectedNum > 0)
//            return true;
//        else
//            return false;
//    }


}
