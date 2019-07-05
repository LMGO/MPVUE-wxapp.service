package com.wx.demo.dao;

import com.wx.demo.entity.Lfcomment;
import com.wx.demo.entity.Lostandfound;

import java.util.List;

public interface LostandfoundDao {
    List<Lostandfound> queryLostandfound();
    int insertLostandfound(String lfId, String lfDes, String userId, String lfTheme, String lfTime, String userNickname, String userHead);
    int deleteLostandfound(String lfId);
    int insertPicture(String lfId);
    int insertComment(String lfcommentId, String userId, String userNickname, String lfcommentContent, String lfId);
    List<Lfcomment> queryComment(String lfId);
    List<Lostandfound> queryMy(String userId);
    int queryCommentcount(String lfId);
    int updateFound(String lfId);
    int updateNotfound(String lfId);
}
