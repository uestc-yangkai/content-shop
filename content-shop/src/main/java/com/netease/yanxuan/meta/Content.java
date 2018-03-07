package com.netease.yanxuan.meta;

import javax.validation.constraints.Size;

/**
 * Created by kaizige on 2018/1/28.
 */
public class Content {
    private int id;
    @Size(min=2,max=80,message = "{content.title.size}")
    private String title;
    private String img;
    @Size(min=2,max=140,message = "{content.summary.size}")
    private String summary;
    @Size(min=2,max=1000,message ="{content.body.size}")
    private String body;
    private int mark;
    private double currentPrice;
    public Content(){}

    @Override
    public String toString() {
        return "Content{" +
                "body='" + body + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", summary='" + summary + '\'' +
                ", mark=" + mark +
                ", currentPrice=" + currentPrice +
                '}';
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
