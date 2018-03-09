package com.netease.yanxuan.web.controller;

import com.netease.yanxuan.meta.User;
import com.netease.yanxuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kaizige on 2018/1/30.
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/loginTable", method = RequestMethod.GET)
    public String loginPre() {
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map login(HttpServletRequest request, HttpServletResponse response, HttpSession session,
                     @RequestParam("userName") String userName, @RequestParam("passWord") String passWord) {
        User user = userService.getUser(userName, passWord);
        Map map = new HashMap<String, String>();
        if (user != null) {
            map.put("code", "200");
            session.setAttribute("user", user);
        }else {
            map.put("code", "100");
        }
        System.out.println(map.get("code"));
        System.out.println(user);
        return map;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        session.setAttribute("user", null);
        return "forward:/";
    }
}
