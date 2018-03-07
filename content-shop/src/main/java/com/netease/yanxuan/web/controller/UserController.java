package com.netease.yanxuan.web.controller;

import com.netease.yanxuan.meta.User;
import com.netease.yanxuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by kaizige on 2018/1/30.
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/loginForm",method = RequestMethod.GET)
    public String loginPre(){
        return "/login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session,
                      @RequestParam("userName") String userName, @RequestParam("passWord") String passWord){
                User user=userService.getUser(userName,passWord);
                if(user!=null){
                         session.setAttribute("user",user);
                        return "forward:/";
                }else{
                        return "forward:/loginForm";
                      }

    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session){
            session.setAttribute("user",null);
            return "forward:/";
    }
}
