package com.netease.yanxuan.dao;

import com.netease.yanxuan.meta.Content;
import com.netease.yanxuan.meta.ContentView;

import java.util.List;

/**
 * Created by kaizige on 2018/1/28.
 */
public interface ContentMapper {
    /**
     * @return 返回所有内容
     */
    List<Content> getContentList();

    /**
     *
     * @return 返回未购买内容列表
     */
    List<Content> getNotbuyContentList();

    /**
     *
     * @return 返回已购买数量
     */
    int getBuyedCount();

    /**
     * 根据id删除内容
     * @param contentId
     * @return
     */
    int deleteContent(int contentId);

    /**
     * 根据id获取内容
     * @param contentId
     * @return
     */
    Content getContent(int contentId);

    /**
     * 根据id修改购买内容
     * @param
     * @return
     */
    int updateContent(Content content);

    /**
     * 增加内容
     * @return
     */
    int addContent(Content content);
    int getMarkById(int contentId);

    ContentView getContentView(int contentId);
    public int updateMark(int contentId);
    public int getSumContent();
}
