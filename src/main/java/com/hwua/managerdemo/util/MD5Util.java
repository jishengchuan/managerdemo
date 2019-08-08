package com.hwua.managerdemo.util;

import org.springframework.util.DigestUtils;

public class MD5Util {
    public static String getMd5(String str){
        str = DigestUtils.md5DigestAsHex(str.getBytes());
        str = DigestUtils.md5DigestAsHex(str.getBytes());
        str = DigestUtils.md5DigestAsHex(str.getBytes());
        str = DigestUtils.md5DigestAsHex(str.getBytes());
        str = DigestUtils.md5DigestAsHex(str.getBytes());
        str = DigestUtils.md5DigestAsHex(str.getBytes());
        str = DigestUtils.md5DigestAsHex(str.getBytes());
        str = DigestUtils.md5DigestAsHex(str.getBytes());
        str = DigestUtils.md5DigestAsHex(str.getBytes());
        str = DigestUtils.md5DigestAsHex(str.getBytes());
        return str;
    }
}
