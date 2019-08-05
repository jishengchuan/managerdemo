package com.hwua.managerdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.hwua.managerdemo.mapper")
public class ManagerdemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(ManagerdemoApplication.class, args);
    }

}
