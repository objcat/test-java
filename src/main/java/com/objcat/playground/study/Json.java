package com.objcat.playground.study;

import com.alibaba.fastjson.JSONObject;

public class Json {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "zhangsan");
        System.out.println(jsonObject);
    }
}
