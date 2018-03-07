package com.netease.yanxuan.dao;

import com.netease.yanxuan.meta.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by kaizige on 2018/1/27.
 */
public interface UserMapper {
    User hasUser(@Param("userName") String userName, @Param("passWord") String passWord);
}
