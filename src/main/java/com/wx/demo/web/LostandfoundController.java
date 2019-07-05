package com.wx.demo.web;

import com.wx.demo.entity.Lostandfound;
import com.wx.demo.service.LostandfoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class LostandfoundController {
    @Autowired
    private LostandfoundService lostandfoundService;

    @RequestMapping(value = "/listlostandfound", method = RequestMethod.GET)
    private Map<String, Object> Listlostandfound() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Lostandfound> lostandfound = lostandfoundService.queryLostandfound();
        for(int i = 0; i < lostandfound.size(); i++){
            String lfId = lostandfound.get(i).getLfId();
            lostandfound.get(i).setLfcomment(lostandfoundService.queryComment(lfId));
            lostandfound.get(i).setLfComm(lostandfoundService.queryCommentcount(lfId));
        }
        modelMap.put("lostandfoundList", lostandfound);
        return modelMap;
    }

    @RequestMapping(value = "/insertlostandfound", method = RequestMethod.POST)
    private Map<String, Object> insertLostandfound(String lfDes, String userId, String lfTheme, String lfTime, String userNickname, String userHead){
        SimpleDateFormat df = new SimpleDateFormat(("yyyy-MM-dd HH:mm:ss"));
        String lfId = df.format(new Date()) + " "+ userId;
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", lostandfoundService.insertLostandfound(lfId, lfDes, userId, lfTheme, lfTime, userNickname, userHead));
        modelMap.put("lfId", lfId);
        return modelMap;
    }

    @RequestMapping(value = "/deletelostandfound", method = RequestMethod.POST)
    private Map<String, Object> deleteLostandfound(String lfId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", lostandfoundService.deleteLostandfound(lfId));
        return modelMap;
    }

    @RequestMapping(value = "/insertlfcomment", method = RequestMethod.POST)
    private Map<String, Object> insertLfcomment(String userId, String userNickname, String lfcommentContent, String lfId){
        SimpleDateFormat df = new SimpleDateFormat(("yyyy-MM-dd HH:mm:ss"));
        String lfcommentId = df.format(new Date()) + " "+ userId;
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", lostandfoundService.insertComment(lfcommentId, userId, userNickname, lfcommentContent, lfId));
        modelMap.put("lfcommentId", lfcommentId);
        return modelMap;
    }

    @RequestMapping(value = "/listmylf", method = RequestMethod.GET)
    private Map<String, Object> ListMyLf(String userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Lostandfound> lostandfound = lostandfoundService.queryMy(userId);
        for(int i = 0; i < lostandfound.size(); i++){
            String lfId = lostandfound.get(i).getLfId();
            lostandfound.get(i).setLfcomment(lostandfoundService.queryComment(lfId));
            lostandfound.get(i).setLfComm(lostandfoundService.queryCommentcount(lfId));
        }
        modelMap.put("lostandfoundList", lostandfound);
        return modelMap;
    }

    @RequestMapping(value = "/updatefound", method = RequestMethod.POST)
    private Map<String, Object> updateFound(String lfId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", lostandfoundService.updateFound(lfId));
        return modelMap;
    }

    @RequestMapping(value = "/updatenotfound", method = RequestMethod.POST)
    private Map<String, Object> updateNotfound(String lfId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", lostandfoundService.updateNotfound(lfId));
        return modelMap;
    }
}
