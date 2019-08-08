package com.hwua.managerdemo.execption;

import com.hwua.managerdemo.util.ExceptionCode;

public class Execption extends RuntimeException {

    private int code;

    public Execption(ExceptionCode exceptionCode){
        super(exceptionCode.getMsg());
        this.code = exceptionCode.getCode();
    }

    public int getCode() {
        return code;
    }
}
