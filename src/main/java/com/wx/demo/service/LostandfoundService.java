package com.wx.demo.service;

import com.wx.demo.entity.Lfcomment;
import com.wx.demo.entity.Lostandfound;

import java.util.List;

public interface LostandfoundService {
    List<Lostandfound> queryLostandfound();
    boolean insertLostandfound(String lfId, String lfDes, String userId, String lfTheme, String lfTime, String userNickname, String userHead);
    boolean deleteLostandfound(String lfId);
    boolean insertPicture(String lfId);
    boolean insertComment(String lfcommentId, String userId, String userNickname, String lfcommentContent, String lfId);
    List<Lfcomment> queryComment(String lfId);
    List<Lostandfound> queryMy(String userId);
    int queryCommentcount(String lfId);
    boolean updateFound(String lfId);
    boolean updateNotfound(String lfId);
}
