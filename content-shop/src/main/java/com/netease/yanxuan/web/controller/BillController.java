package com.netease.yanxuan.web.controller;

import com.netease.yanxuan.meta.BillView;
import com.netease.yanxuan.service.BillService;
import com.netease.yanxuan.util.PropertiesRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by kaizige on 2018/2/2.
 */
@Controller
public class BillController {
    @Autowired
    BillService billService;
    @RequestMapping(value = "/bill/add",method = RequestMethod.GET)
    public String add(Model model){
        billService.add();
        return "forward:/bill";
    }
    @RequestMapping(value = "/bill",method = RequestMethod.GET)
    public String check(Model model){
        List<BillView> billViewList=billService.getBillView();
        System.out.println(billViewList);
        model.addAttribute("buyList",billViewList);
        return "account";
    }
}
