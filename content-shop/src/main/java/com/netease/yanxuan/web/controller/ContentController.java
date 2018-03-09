package com.netease.yanxuan.web.controller;

import com.netease.yanxuan.meta.Content;
import com.netease.yanxuan.meta.ContentView;
import com.netease.yanxuan.meta.User;
import com.netease.yanxuan.service.BillService;
import com.netease.yanxuan.service.ContentService;
import com.netease.yanxuan.util.PropertiesRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kaizige on 2018/1/28.
 */
@Controller
public class ContentController {
    @Autowired
    ContentService contentService;
    /**
     * 列出所有内容
     * @param map
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String listContent(ModelMap map,HttpServletResponse response,HttpSession session,HttpServletRequest request){
        List<Content> contents=new ArrayList<Content>();
        contents=contentService.contentList();
        System.out.println(contents);
        map.addAttribute("productList",contents);

        return "index";
    }

    /**
     * 根据id列出某个内容
     * @param contentId
     * @param map
     * @param response
     * @param session
     * @return
     */
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public String listContentOne(@RequestParam("id") Integer contentId, ModelMap map,HttpServletResponse response,HttpSession session){
        User user=(User)session.getAttribute("user");
        ContentView content=contentService.getDetailContent(contentId);
        map.addAttribute("product",content);
        return "show";
    }
    @RequestMapping(value = "/content/add",method = RequestMethod.POST)
    public String addContent(HttpSession session,Content content,
                            Model model){
        System.out.println(content);
            boolean flag=contentService.addContent(content);
            model.addAttribute("product",content);
            return "publicSubmit";
       // return "forward";
    }
    @RequestMapping("/content/public")
    public String addContentPre( HttpServletRequest request, HttpServletResponse response){
        return "public";
    }
    @RequestMapping("/content/edit")
    public String updateContentPre(@RequestParam("id") String contentId, HttpServletRequest request, HttpSession session,HttpServletResponse response,Model model){
            int id=Integer.valueOf(contentId);
            Content content=contentService.getContentOne(id);
            model.addAttribute("product",content);
            System.out.println(content);
            return "edit";
    }
    @RequestMapping(value = "/content/update",method = RequestMethod.POST)
    public String updateContent(@RequestParam("id") Integer id, Model model, HttpServletRequest request, Content content){
        content.setId(id);
        boolean b=contentService.updateContent(content);
        if(b){
            model.addAttribute("product",content);
        }
        return "editSubmit";
    }

    /**
     *
     * @param contentId
     * @param model
     * @param request
     * @param response
     * @return  返回json字符串，code=200表示成功
     */
    @RequestMapping(value = "/content/delete",method = RequestMethod.GET)
    @ResponseBody
    public Map deleteContent(@RequestParam("id") int contentId,Model model,HttpServletRequest request,HttpServletResponse response){
        System.out.println(contentId);
        boolean flag=contentService.deleteContent(contentId);
        Map map=new HashMap<String,String>();
        map.put("code","200");
        return map;
    }

}
