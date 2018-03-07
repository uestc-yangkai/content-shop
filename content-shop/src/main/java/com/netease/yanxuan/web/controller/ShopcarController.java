package com.netease.yanxuan.web.controller;

import com.netease.yanxuan.meta.ShopCarView;
import com.netease.yanxuan.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by kaizige on 2018/1/30.
 */
@Controller
public class ShopcarController {
    @Autowired
    ShopCarService shopCarService;

    @RequestMapping(value = "/shopcar/add", method = RequestMethod.GET)
    public String add(Model model, @RequestParam("id") Integer contentId) {
        boolean f = shopCarService.add(contentId);
        if (f) {
            model.addAttribute("status", 1);//表示添加到购物车成功
        }
        return "shopcarSubmit";
    }

    @RequestMapping(value = "/shopcar",method = RequestMethod.GET)
    public String list(Model model) {
        List<ShopCarView> carViewList = shopCarService.getCarViewList();
        model.addAttribute("shopcar", carViewList);
        System.out.println(carViewList);
        return "shopcar";
    }
}
