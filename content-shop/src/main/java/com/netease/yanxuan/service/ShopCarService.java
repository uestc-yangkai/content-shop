package com.netease.yanxuan.service;

import com.netease.yanxuan.dao.ContentMapper;
import com.netease.yanxuan.dao.ShopCarMapper;
import com.netease.yanxuan.meta.ShopCarView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kaizige on 2018/1/28.
 */
@Service
public class ShopCarService {
    @Autowired
    ShopCarMapper shopCarMapper;
    @Autowired
    ContentMapper contentMapper;
    public  List<ShopCarView> getCarViewList(){
        return shopCarMapper.getCarViewList();
    }

    public boolean add(int contentId){
        Integer count=shopCarMapper.findCountByContentId(contentId);
        if(count==null){
            System.out.println("hello");
            shopCarMapper.addShopCar(contentId);
        }else{
            System.out.println(count);
            count++;
            shopCarMapper.updateCount(contentId,count);
        }
//       int i= shopCarMapper.addShopCar(contentId);
//        return i>0;
        return true;
    }
    public boolean delete(int id){
        int i=shopCarMapper.deleteShopCar(id);
        return i>0;
    }

}
