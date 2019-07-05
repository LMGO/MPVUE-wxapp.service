package com.wx.demo.service;

import com.wx.demo.entity.Wecomment;
import com.wx.demo.entity.Wespace;
import com.wx.demo.entity.Weup;
import java.util.List;

public interface WespaceService {
    List<Wespace> queryWespace();
    List<Weup> queryUp(String userId);
    boolean insertWespace(String microId, String microDes, String userId, String microTime, String userNickname, String userHead);
    boolean deleteWespace(String microId);
    boolean upWespace(String microId, String userId);
    boolean downWespace(String microId, String userId);
    boolean insertComment(String wecommentId, String userId, String userNickname, String wecommentContent, String microId);
    boolean upJudge(String microId, String userId);
    List<Wecomment> queryComment(String microId);
    List<Wespace> queryHot();
    List<Wespace> queryMy(String userId);
    int queryCommentcount(String microId);
}
