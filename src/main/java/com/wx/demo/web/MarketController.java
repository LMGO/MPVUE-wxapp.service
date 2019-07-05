package com.wx.demo.web;

import com.wx.demo.entity.Market;
import com.wx.demo.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class MarketController {
    @Autowired
    private MarketService marketService;

    @RequestMapping(value = "/listmarket", method = RequestMethod.GET)
    private Map<String, Object> ListMarket(String userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Market> market = marketService.queryMarket();
        for(int i = 0; i < market.size(); i++){
            String marketId = market.get(i).getMarketId();
            market.get(i).setMarcomment(marketService.queryComment(marketId));
            if(marketService.upJudge(marketId, userId)){
                market.get(i).setIslike(true);
            }
            else{
                market.get(i).setIslike(false);
            }
            market.get(i).setMarketComm(marketService.queryCommentcount(marketId));
        }
        modelMap.put("marketList", market);
        return modelMap;
    }

    @RequestMapping(value = "/insertmarket", method = RequestMethod.POST)
    private Map<String, Object> insertMarket(String marketTheme, String marketDes,String userId, String marketTime, String userNickname, String userHead){
        SimpleDateFormat df = new SimpleDateFormat(("yyyy-MM-dd HH:mm:ss"));
        String marketId = df.format(new Date()) + " "+ userId;
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", marketService.insertMarket(marketId, marketTheme, marketDes, userId, marketTime, userNickname, userHead));
        modelMap.put("marketId", marketId);
        return modelMap;
    }

    @RequestMapping(value = "/deletemarket", method = RequestMethod.POST)
    private Map<String, Object> deleteMarket(String marketId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", marketService.deleteMarket(marketId));
        return modelMap;
    }

    @RequestMapping(value = "/upmarket", method = RequestMethod.POST)
    private Map<String, Object> upMarket(String marketId, String userId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", marketService.upMarket(marketId, userId));
        return modelMap;
    }

    @RequestMapping(value = "/downmarket", method = RequestMethod.POST)
    private Map<String, Object> downMarket(String marketId, String userId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", marketService.downMarket(marketId, userId));
        return modelMap;
    }

    @RequestMapping(value = "/insertmarcomment", method = RequestMethod.POST)
    private Map<String, Object> insertMarcomment(String userId, String userNickname, String marcommentContent, String marketId){
        SimpleDateFormat df = new SimpleDateFormat(("yyyy-MM-dd HH:mm:ss"));
        String marcommentId = df.format(new Date()) + " "+ userId;
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", marketService.insertComment(marcommentId, userId, userNickname, marcommentContent, marketId));
        modelMap.put("microId", marketId);
        return modelMap;
    }

    @RequestMapping(value = "/listmymarket", method = RequestMethod.GET)
    private Map<String, Object> ListMyMarket(String userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Market> market = marketService.queryMy(userId);
        for(int i = 0; i < market.size(); i++){
            String marketId = market.get(i).getMarketId();
            market.get(i).setMarcomment(marketService.queryComment(marketId));
            if(marketService.upJudge(marketId, userId)){
                market.get(i).setIslike(true);
            }
            else{
                market.get(i).setIslike(false);
            }
            market.get(i).setMarketComm(marketService.queryCommentcount(marketId));
        }
        modelMap.put("marketList", market);
        return modelMap;
    }

    @RequestMapping(value = "/updatedeal", method = RequestMethod.POST)
    private Map<String, Object> updateDeal(String marketId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", marketService.updateDeal(marketId));
        return modelMap;
    }

    @RequestMapping(value = "/updatenotdeal", method = RequestMethod.POST)
    private Map<String, Object> updateNotdeal(String marketId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", marketService.updateNotDeal(marketId));
        return modelMap;
    }

    @RequestMapping(value = "/uploadmarimage", method = RequestMethod.POST)
    private ModelAndView uploadimage(HttpServletRequest request, HttpServletResponse response, String microId)throws IOException{
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = req.getFile("file");
        String realPath = "C:\\Users\\Administrator\\Desktop\\imag";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String nowTime = sdf.format(new Date().getTime());
        String originalLastName = multipartFile.getOriginalFilename();
        String picLastName = originalLastName.substring(originalLastName.lastIndexOf("."));
        String picName = microId + "." + nowTime + picLastName;
        try{
            File dir = new File(realPath);
            if(!dir.exists()){
                dir.mkdir();
                System.out.println("创建文件目录成功：" + realPath);
            }
            File file = new File(realPath, picName);
            multipartFile.transferTo(file);
            System.out.println("添加图片成功！");
        }catch (IOException e){
            e.printStackTrace();
        }catch (IllegalStateException e){
            e.printStackTrace();
        }
        return null;
    }
}
