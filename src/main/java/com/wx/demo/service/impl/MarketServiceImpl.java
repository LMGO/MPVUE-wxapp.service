package com.wx.demo.service.impl;

import com.wx.demo.dao.MarketDao;
import com.wx.demo.entity.Marcomment;
import com.wx.demo.entity.Market;
import com.wx.demo.entity.Marup;
import com.wx.demo.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketServiceImpl implements MarketService {
    @Autowired
    private MarketDao marketDao;

    @Override
    public List<Market> queryMarket() {
        return marketDao.queryMarket();
    }

    @Override
    public boolean insertMarket(String marketId, String marketTheme, String marketDes, String userId, String marketTime, String userNickname, String userHead) {
        int effectedNum = marketDao.insertMarket(marketId, marketTheme, marketDes, userId, marketTime, userNickname, userHead);
        if(effectedNum > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteMarket(String marketId) {
        int effectedNum = marketDao.deleteMarket(marketId);
        if(effectedNum > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean upMarket(String marketId, String userId) {
        int upYes = 1;
        int effectedNum = marketDao.upMarket(marketId) + marketDao.insertUp(marketId, userId, upYes);
        if(effectedNum > 1)
            return true;
        else
            return false;
    }

    @Override
    public boolean downMarket(String marketId, String userId) {
        int effectedNum = marketDao.downMarket(marketId) + marketDao.deleteUp(marketId, userId);
        if(effectedNum > 1)
            return true;
        else
            return false;
    }

    @Override
    public boolean insertComment(String marcommentId, String userId, String userNickname, String marcommentContent, String marketId) {
        int effectedNum = marketDao.insertComment(marcommentId, userId, userNickname, marcommentContent, marketId);
        if(effectedNum > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean upJudge(String marketId, String userId) {
        if(marketDao.upJudge(marketId, userId).size()>0)
            return true;
        else
            return false;
    }

    @Override
    public List<Marcomment> queryComment(String marketId) {
        return marketDao.queryComment(marketId);
}

    @Override
    public List<Market> queryMy(String userId) {
        return marketDao.queryMy(userId);
    }

    @Override
    public int queryCommentcount(String marketId) {
        return marketDao.queryCommentcount(marketId);
    }

    @Override
    public boolean updateDeal(String marketId) {
        int effectedNum = marketDao.updateDeal(marketId);
        if(effectedNum > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateNotDeal(String marketId) {
        int effectedNum = marketDao.updateNotDeal(marketId);
        if(effectedNum > 0)
            return true;
        else
            return false;
    }
}
