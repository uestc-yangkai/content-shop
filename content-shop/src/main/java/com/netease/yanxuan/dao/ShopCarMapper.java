package com.netease.yanxuan.dao;

import com.netease.yanxuan.meta.ShopCar;
import com.netease.yanxuan.meta.ShopCarView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by kaizige on 2018/1/28.
 */
public interface ShopCarMapper {
    /**
     * 返回购物车中所有内容id列表
     * @return
     */
    public List<ShopCar> getShopCarAll();

    /**
     * 增加到购物车
     * @param contentId
     */
    public int addShopCar(@Param("contentId") Integer contentId);
    public int updateCount(@Param("contentId") int contentId, @Param("count") int count);

    /**
     * 根据购物车id删除购物车
     * @param id
     * @return
     */
    public int deleteShopCar(int id);
    public List<ShopCarView> getCarViewList();
    Integer findCountByContentId(int contentId);
}
