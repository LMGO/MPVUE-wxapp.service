package com.wx.demo.web;

import com.wx.demo.entity.Wecomment;
import com.wx.demo.entity.Wespace;
import com.wx.demo.entity.Weup;
import com.wx.demo.service.WespaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/admin")
public class WespaceController {
    @Autowired
    private WespaceService wespaceService;

    @RequestMapping(value = "/listwespace", method = RequestMethod.GET)
    private Map<String, Object> ListWespace(String userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Wespace> wespace = wespaceService.queryWespace();
        for(int i = 0; i < wespace.size(); i++){
            String microId = wespace.get(i).getMicroId();
            wespace.get(i).setWecomment(wespaceService.queryComment(microId));
            if(wespaceService.upJudge(microId, userId)){
                wespace.get(i).setIslike(true);
            }
            else{
                wespace.get(i).setIslike(false);
            }
            wespace.get(i).setMicroComm(wespaceService.queryCommentcount(microId));
        }
        modelMap.put("wespaceList", wespace);
        return modelMap;
    }

    @RequestMapping(value = "/queryup", method = RequestMethod.GET)
    private Map<String, Object> Queryup(String userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Weup> weup = wespaceService.queryUp(userId);
        modelMap.put("upList", weup);
        return modelMap;
    }

    @RequestMapping(value = "/insertwespace", method = RequestMethod.POST)
    private Map<String, Object> insertWespace(String microDes, String userId, String microTime, String userNickname, String userHead){
        SimpleDateFormat df = new SimpleDateFormat(("yyyy-MM-dd HH:mm:ss"));
        String microId = df.format(new Date()) + " "+ userId;
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", wespaceService.insertWespace(microId, microDes, userId, microTime, userNickname, userHead));
        modelMap.put("microId", microId);
        return modelMap;
    }

    @RequestMapping(value = "/deletewespace", method = RequestMethod.POST)
    private Map<String, Object> deleteWespace(String microId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", wespaceService.deleteWespace(microId));
        return modelMap;
    }

    @RequestMapping(value = "/upwespace", method = RequestMethod.POST)
    private Map<String, Object> upWespace(String microId, String userId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", wespaceService.upWespace(microId, userId));
        return modelMap;
    }

    @RequestMapping(value = "/downwespace", method = RequestMethod.POST)
    private Map<String, Object> downWespace(String microId, String userId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", wespaceService.downWespace(microId, userId));
        return modelMap;
    }

    @RequestMapping(value = "/insertcomment", method = RequestMethod.POST)
    private Map<String, Object> insertComment(String userId, String userNickname, String wecommentContent, String microId){
        SimpleDateFormat df = new SimpleDateFormat(("yyyy-MM-dd HH:mm:ss"));
        String wecommentId = df.format(new Date()) + " "+ userId;
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", wespaceService.insertComment(wecommentId, userId, userNickname, wecommentContent, microId));
        modelMap.put("microId", microId);
        return modelMap;
    }

    @RequestMapping(value = "/listhotwespace", method = RequestMethod.GET)
    private Map<String, Object> ListHotWespace(String userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Wespace> wespace = wespaceService.queryHot();
        for(int i = 0; i < wespace.size(); i++){
            String microId = wespace.get(i).getMicroId();
            wespace.get(i).setWecomment(wespaceService.queryComment(microId));
            if(wespaceService.upJudge(microId, userId)){
                wespace.get(i).setIslike(true);
            }
            else{
                wespace.get(i).setIslike(false);
            }
            wespace.get(i).setMicroComm(wespaceService.queryCommentcount(microId));
        }
        modelMap.put("wespaceList", wespace);
        return modelMap;
    }

    @RequestMapping(value = "/listmy", method = RequestMethod.GET)
    private Map<String, Object> ListMy(String userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Wespace> wespace = wespaceService.queryMy(userId);
        for(int i = 0; i < wespace.size(); i++){
            String microId = wespace.get(i).getMicroId();
            wespace.get(i).setWecomment(wespaceService.queryComment(microId));
            if(wespaceService.upJudge(microId, userId)){
                wespace.get(i).setIslike(true);
            }
            else{
                wespace.get(i).setIslike(false);
            }
            wespace.get(i).setMicroComm(wespaceService.queryCommentcount(microId));
        }
        modelMap.put("wespaceList", wespace);
        return modelMap;
    }

    @RequestMapping(value = "/uploadweimage", method = RequestMethod.POST)
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
//    @RequestMapping(value = "/upjudge", method = RequestMethod.POST)
//    private Map<String, Object> upJudge(String microId, String userId){
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        List<Weup> weup = wespaceService.upJudge(microId, userId);
//        modelMap.put("success", weup);
//        return modelMap;
//    }

//    @RequestMapping(value = "/insertPicture", method = RequestMethod.POST)
//    private ModelAndView uploadPicture(HttpServletRequest request, HttpServletResponse response)

//    @RequestMapping(value = "/uploadimage", method = RequestMethod.POST)
//    public LocaleContext uoloadImage(HttpServletRequest request, LocaleContext localeContext) throws IOException {
//        String localPathDir = "C:\\Users\\Administrator\\Desktop\\imag";
//        File logoSaveFile = new File(localPathDir);
//        if (request instanceof MultipartHttpServletRequest) {
//            MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
//            Iterator iter = mr.getFileMap().values().iterator();
//            if(iter.hasNext()){
//                MultipartFile file = (MultipartFile) iter.next();
//                String Oname = file.getOriginalFilename();
//                String fileName = localPathDir + File.separator + Oname;
//                File files = new File(fileName);
//                InputStream inputstream = file.getInputStream();
//                byte[] bytes = new byte[1024];
//                FileOutputStream outstream = new FileOutputStream(fileName);
//                int index;
//                while((index = inputstream.read(bytes)) != -1){
//                    outstream.write(bytes, 0, index);
//                    outstream.flush();
//                }
//                localeContext.
//                outstream.close();
//                inputstream.close();
//            }
//        }
//    return localeContext;
//    }
}