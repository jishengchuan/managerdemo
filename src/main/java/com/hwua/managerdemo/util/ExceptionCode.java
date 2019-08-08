package com.hwua.managerdemo.util;

//枚举类，实现创建一系列的对象
public enum ExceptionCode {

    //枚举元素，多个之间用逗号分隔
    INVALID_PASSWORD(101,"密码错误"),
    USERNAME_NOT_EXISTS(102,"用户名不存在"),
    USERNAME_ALREADY_EXIST(103,"用户已存在");

    private int code;
    private String msg;
    //枚举中的构造方法必须私有化
    ExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
