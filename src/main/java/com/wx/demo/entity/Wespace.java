package com.wx.demo.entity;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Wespace {
    private String microId;
    private String microPict;
    private String microDes;
    private String userId;
    private String microTime;
    private String userNickname;
    private String userHead;
    private boolean islike;
    private List<Wecomment> wecomment;
    private int microComm;

    public boolean isIslike() {
        return islike;
    }

    public void setIslike(boolean islike) {
        this.islike = islike;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public int getMicroUp() {
        return microUp;
    }

    public void setMicroUp(int microUp) {
        this.microUp = microUp;
    }

    private int microUp;

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getMicroId() {
        return microId;
    }

    public void setMicroId(String microId) {
        this.microId = microId;
    }

    public String getMicroPict() {
        return microPict;
    }

    public void setMicroPict(String microPict) {
        this.microPict = microPict;
    }

    public String getMicroDes() {
        return microDes;
    }

    public void setMicroDes(String microDes) {
        this.microDes = microDes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMicroTime() {
        return microTime;
    }

    public void setMicroTime(String microTime) {
        this.microTime = microTime;
    }

    public List<Wecomment> getWecomment() {
        return wecomment;
    }

    public void setWecomment(List<Wecomment> wecomment) {
        this.wecomment = wecomment;
    }

    public int getMicroComm() {
        return microComm;
    }

    public void setMicroComm(int microComm) {
        this.microComm = microComm;
    }
}
