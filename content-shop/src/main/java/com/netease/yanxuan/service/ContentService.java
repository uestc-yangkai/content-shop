package com.netease.yanxuan.service;

import com.netease.yanxuan.dao.ContentMapper;
import com.netease.yanxuan.meta.Content;
import com.netease.yanxuan.meta.ContentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kaizige on 2018/1/28.
 */
@Service
public class ContentService {
    @Autowired
    ContentMapper contentMapper;
    public boolean addContent(Content content){
        contentMapper.addContent(content);
        return true;
    }
    public ContentView getDetailContent(int contentId){
        if(contentMapper.getMarkById(contentId)==0){
            Content content=contentMapper.getContent(contentId);
            ContentView view =new ContentView();
            view.setId(content.getId());
            view.setTitle(content.getTitle());
            view.setSummary(content.getSummary());
            view.setImg(content.getImg());
            view.setCurrentPrice(content.getCurrentPrice());
            view.setBody(content.getBody());
            view.setMark(content.getMark());
            return view;
        }
        return contentMapper.getContentView(contentId);
    }
    public List<Content> contentList(){
        return contentMapper.getContentList();
    }
    public Content getContentOne(int contentId){
       return  contentMapper.getContent(contentId);
    }
    public boolean updateContent(Content content)  {
        int i=contentMapper.updateContent(content);
        return i>0;
    }
    public boolean deleteContent(int contentId){
        int i=contentMapper.deleteContent(contentId);
        return i>0;
    }
}
