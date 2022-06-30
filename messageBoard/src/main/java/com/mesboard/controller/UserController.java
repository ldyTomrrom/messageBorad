package com.mesboard.controller;

import com.mesboard.contants.Constants;
import com.mesboard.model.User;
import com.mesboard.service.UserService;
import com.mesboard.utils.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 自出洞来无敌手 --
 * 2022/6/24
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/user/login")
    public ReturnObject login(@RequestParam("account")String at,
                              @RequestParam("password")String pwd,
                              HttpSession session,
                              HttpServletRequest request){
        ReturnObject r=ReturnObject.success();
        pwd=MD5Util.getMD5(pwd);
        User u=new User();
        u.setLastLoginTime(DateUtils.formatDateTime(new Date()));
        u.setLastLoginIp(IpAddressUtil.getIpAddress(request));
         User user= userService.userLogin(at,pwd);
         if (user!=null){
             session.setAttribute(Constants.SESSION_USER,user);
//        设置过期时间为三十分钟
             session.setMaxInactiveInterval(60*30);
         }else{
             return ReturnObject.fail("不存在的用户");
         }
        return r;
    }
    @PostMapping("/user/registry")
    public ReturnObject registry(@RequestParam("account")String at,
                                 @RequestParam("password")String paw,
                                 HttpServletRequest request){
        ReturnObject r=ReturnObject.success();
        User user=new User();
        user.setAcId(UUIDUtils.getUUID());
        System.out.println(at);

        user.setAccount(at);
        user.setPassword(MD5Util.getMD5(paw));
        user.setAcOpenTime(DateUtils.formatDateTime(new Date()));
        user.setLastLoginTime("新用户");
        user.setAcSts("Y");
        user.setLastLoginIp(IpAddressUtil.getIpAddress(request));

       int result= userService.insertUser(user);
       if (result!=1){

           return ReturnObject.fail("注册失败,请联系管理员");
       }

        return r;
    }

    @GetMapping("/checkPhone")
    public  ReturnObject checkPhone(@RequestParam("at")String at){
        ReturnObject result = ReturnObject.success();
           User user= userService.checkPhone(at);
           if (user!=null){
               return ReturnObject.fail("已存在的账户,请更换后输入");
           }
        return result;


    }
}
