package com.wx.demo.dao;

import com.wx.demo.entity.Wespace;
import com.wx.demo.entity.Weup;
import com.wx.demo.entity.Wecomment;

import java.util.List;

public interface WespaceDao {
    List<Wespace> queryWespace();
    List<Weup> queryUp(String userId);
    int insertWespace(String microId, String microDes, String userId, String microTime, String userNickname, String userHead);
    int deleteWespace(String microId);
    int upWespace(String microId);
    int downWespace(String microId);
    int insertUp(String microId, String userId, int upYes);
    int deleteUp(String microId, String userId);
    int deleteUserup(String microId);
    int insertPicture(String microId);
    int insertComment(String wecommentId, String userId, String userNickname, String wecommentContent, String microId);
    List<Weup> upJudge(String microId, String userId);
    List<Wecomment> queryComment(String microId);
    List<Wespace> queryHot();
    List<Wespace> queryMy(String userId);
    int queryCommentcount(String microId);
}
