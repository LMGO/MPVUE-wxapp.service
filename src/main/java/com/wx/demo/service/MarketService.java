package com.wx.demo.service;

import com.wx.demo.entity.Marcomment;
import com.wx.demo.entity.Market;
import com.wx.demo.entity.Marup;

import java.util.List;

public interface MarketService {
    List<Market> queryMarket();
    boolean insertMarket(String marketId, String marketTheme, String marketDes, String userId, String marketTime, String userNickname, String userHead);
    boolean deleteMarket(String marketId);
    boolean upMarket(String marketId, String userId);
    boolean downMarket(String marketId, String userId);
    boolean insertComment(String marcommentId, String userId, String userNickname, String marcommentContent, String marketId);
    boolean upJudge(String marketId, String userId);
    List<Marcomment> queryComment(String marketId);
    List<Market> queryMy(String userId);
    int queryCommentcount(String marketId);
    boolean updateDeal(String marketId);
    boolean updateNotDeal(String marketId);
}
