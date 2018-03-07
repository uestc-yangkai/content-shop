package com.netease.yanxuan.service;

import com.netease.yanxuan.dao.UserMapper;
import com.netease.yanxuan.meta.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kaizige on 2018/1/28.
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User getUser(String userName, String passWord){
        return userMapper.hasUser(userName,passWord);
    }
}
