package com.wx.demo.entity;

import java.util.List;

public class Market {
    private String marketId;
    private String marketTheme;
    private String marketDes;
    private String userId;
    private String marketTime;
    private int marketUp;
    private String userNickname;
    private String userHead;
    private int marketComm;
    private List<Marcomment> marcomment;
    private boolean islike;
    private boolean marketDeal;

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getMarketTheme() {
        return marketTheme;
    }

    public void setMarketTheme(String marketTheme) {
        this.marketTheme = marketTheme;
    }

    public String getMarketDes() {
        return marketDes;
    }

    public void setMarketDes(String marketDes) {
        this.marketDes = marketDes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMarketTime() {
        return marketTime;
    }

    public void setMarketTime(String marketTime) {
        this.marketTime = marketTime;
    }

    public int getMarketUp() {
        return marketUp;
    }

    public void setMarketUp(int marketUp) {
        this.marketUp = marketUp;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public int getMarketComm() {
        return marketComm;
    }

    public void setMarketComm(int marketComm) {
        this.marketComm = marketComm;
    }

    public List<Marcomment> getMarcomment() {
        return marcomment;
    }

    public void setMarcomment(List<Marcomment> marcomment) {
        this.marcomment = marcomment;
    }

    public boolean isIslike() {
        return islike;
    }

    public void setIslike(boolean islike) {
        this.islike = islike;
    }

    public boolean isMarketDeal() {
        return marketDeal;
    }

    public void setMarketDeal(boolean marketDeal) {
        this.marketDeal = marketDeal;
    }
}
