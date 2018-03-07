package com.netease.yanxuan.meta;

/**
 * Created by kaizige on 2018/1/28.
 */
public class ShopCar {
    private int id;
    private int content_id;
    private int count;
    public ShopCar(){}
    public ShopCar(int contentId, int count) {
        this.content_id=contentId;
        this.count=count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
