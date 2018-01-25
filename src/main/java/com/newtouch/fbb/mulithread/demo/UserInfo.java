package com.newtouch.fbb.mulithread.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Created by steven on 2018/1/5.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    //用户信息
    private Map<String,String> basicInfo;
    //班级信息
    private Map<String,String> classesInfo;
    //....Other
    private Map<String,String> otherInfo;
}
