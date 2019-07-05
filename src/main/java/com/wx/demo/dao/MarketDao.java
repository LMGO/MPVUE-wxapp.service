package com.wx.demo.dao;

import com.wx.demo.entity.Marcomment;
import com.wx.demo.entity.Market;
import com.wx.demo.entity.Marup;

import java.util.List;

public interface MarketDao {
    List<Market> queryMarket();
    int insertMarket(String marketId, String marketTheme, String marketDes, String userId, String marketTime, String userNickname, String userHead);
    int deleteMarket(String marketId);
    int upMarket(String marketd);
    int downMarket(String marketId);
    int insertUp(String marketId, String userId, int upYes);
    int deleteUp(String marketId, String userId);
    int insertPicture(String marketId);
    int insertComment(String marcommentId, String userId, String userNickname, String marcommentContent, String marketId);
    List<Marup> upJudge(String marketId, String userId);
    List<Marcomment> queryComment(String marketId);
    List<Market> queryMy(String userId);
    int queryCommentcount(String marketId);
    int updateDeal(String marketId);
    int updateNotDeal(String marketId);
}
