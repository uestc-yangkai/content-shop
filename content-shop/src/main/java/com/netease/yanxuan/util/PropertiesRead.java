package com.netease.yanxuan.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by kaizige on 2018/1/31.
 */
public class PropertiesRead {
    static Properties p=new Properties();
    static {
        try{
        p.load(new InputStreamReader(PropertiesRead.class.getClassLoader().getResourceAsStream("msg.properties"),"utf-8"));

        } catch (IOException e) {
            System.out.println("配置文件出错");
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
        return p.getProperty(key);
    }
}
