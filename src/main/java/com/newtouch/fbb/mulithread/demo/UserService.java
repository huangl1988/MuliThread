package com.newtouch.fbb.mulithread.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by steven on 2018/1/8.
 */
public class UserService {

    private static UserService userService;

    private UserService(){};

    public static UserService getUserService(){
        if(userService==null)
            userService=new UserService();
        return  userService;
    }

    /**
     *
     * @param userId
     * @return
     */
    public Map<String,String> getUserBasicInfo(String userId){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map map = new HashMap<String,String>();
        map.put("name","test");
        map.put("age","19");
        return map;
    }

    public Map<String,String> getClassesInfo(String userId) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map map = new HashMap<String,String>();
        map.put("className","one");
        //map.put("g","3");
        return map;
    }

    public Map<String,String> otherInfo(String userId) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map map = new HashMap<String,String>();
        map.put("score","0");
        //map.put("g","3");
        return map;
    }

}
