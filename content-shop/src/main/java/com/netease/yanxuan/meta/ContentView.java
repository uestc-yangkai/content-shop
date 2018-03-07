package com.netease.yanxuan.meta;

import java.sql.Timestamp;

/**
 * Created by kaizige on 2018/2/2.
 */
public class ContentView extends Content {
    private int buyPrice;
    private Timestamp buyDate;

    public Timestamp getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Timestamp buyDate) {
        this.buyDate = buyDate;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }
}
