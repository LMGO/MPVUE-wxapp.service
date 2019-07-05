package com.wx.demo.entity;

import java.util.List;

public class Lostandfound {
    private String lfId;
    private String lfDes;
    private String userId;
    private String lfTheme;
    private String lfTime;
    private String userHead;
    private String userNickname;
    private int lfComm;
    private boolean lfFound;
    private List<Lfcomment> lfcomment;

    public String getLfId() {
        return lfId;
    }

    public void setLfId(String lfId) {
        this.lfId = lfId;
    }

    public String getLfDes() {
        return lfDes;
    }

    public void setLfDes(String lfDes) {
        this.lfDes = lfDes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLfTheme() {
        return lfTheme;
    }

    public void setLfTheme(String lfTheme) {
        this.lfTheme = lfTheme;
    }

    public String getLfTime() {
        return lfTime;
    }

    public void setLfTime(String lfTime) {
        this.lfTime = lfTime;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public int getLfComm() {
        return lfComm;
    }

    public void setLfComm(int lfComm) {
        this.lfComm = lfComm;
    }

    public boolean isLfFound() {
        return lfFound;
    }

    public void setLfFound(boolean lfFound) {
        this.lfFound = lfFound;
    }

    public List<Lfcomment> getLfcomment() {
        return lfcomment;
    }

    public void setLfcomment(List<Lfcomment> lfcomment) {
        this.lfcomment = lfcomment;
    }
}
