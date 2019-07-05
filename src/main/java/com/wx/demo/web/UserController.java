package com.wx.demo.web;

import com.fasterxml.jackson.core.JsonParseException;
import com.wx.demo.entity.User;
import com.wx.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/listuser", method = RequestMethod.GET)
    private Map<String, Object> ListUser(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<User> user = userService.queryUser();
        modelMap.put("userList", user);
        return modelMap;
    }

    @RequestMapping(value="/getuserbyid", method = RequestMethod.GET)
    private Map<String, Object> getUserById(String userId, String userPassword){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        User user = userService.getUserById(userId, userPassword);
        modelMap.put("user", user);
        return modelMap;
    }

    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    private Map<String, Object> updateUser(String userId, String userNickname, String userAcademy, String userQq, String userTelephone){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //返回是否修改成功的信息
        modelMap.put("success", userService.updateUser(userId, userNickname, userAcademy, userQq, userTelephone));
        return modelMap;
    }

    @RequestMapping(value="/updatepassword", method = RequestMethod.POST)
    private Map<String, Object> updatePassword(String userId, String userPassword){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userService.updatePassword(userId, userPassword));
        return modelMap;
    }

    @RequestMapping(value="/getuserhead", method = RequestMethod.POST)
    private Map<String, Object> updateUserHead(String userId, String userHead){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userService.updateUserHead(userId, userHead));
        return modelMap;
    }

//    @RequestMapping(value = "/getuserhead", method = RequestMethod.POST)
//    private ModelAndView uploadPicture(HttpServletRequest request, HttpServletResponse response) throws IOException{
//        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
//        MultipartFile multipartFile = req.getFile("file");
//        String realPath = "C:\\Users\\Administrator\\Desktop\\head";
//        String originalFirstName = multipartFile.getOriginalFilename();
//        String picFirstName = originalFirstName.substring(0, originalFirstName.lastIndexOf("."));
//        String originalLastName = multipartFile.getOriginalFilename();
//        String picLastName = originalLastName.substring(originalLastName.lastIndexOf("."));
//        String picName = picFirstName + "." + picLastName;
//        userService.updateUserHead(picFirstName, picName);
//        try{
//            File file = new File(realPath, picName);
//            multipartFile.transferTo(file);
//            System.out.println("添加头像成功！");
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch(IllegalStateException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
}
