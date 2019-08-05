package com.hwua.managerdemo.util;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String,Object> {

    public static R success(){
        R r = new R();
        r.put("success",true);
        return r;
    }

    public static R success(String message){
        R r = new R();
        r.put("success",true);
        r.put("message",message);
        return r;
    }

    public static R success(Map<String,Object> map){
        R r = new R();
        r.put("success",true);
        r.putAll(map);
        return r;
    }

    public static R success(Object data){
        R r = new R();
        r.put("success",true);
        r.put("data",data);
        return r;
    }

    public static R error(){
        R r = new R();
        r.put("success",false);
        return r;
    }

    public static R error(Exception e){
        R r = new R();
        r.put("success",false);
        r.put("exception",e);
        return r;
    }

    public static R error(String message){
        R r = new R();
        r.put("success",false);
        r.put("message",message);
        return r;
    }

    public static R error(Object data){
        R r = new R();
        r.put("success",false);
        r.put("data",data);
        return r;
    }

    //链式编程
    public R put(String key, Object value){
        super.put(key,value);
        return this;
    }

}
