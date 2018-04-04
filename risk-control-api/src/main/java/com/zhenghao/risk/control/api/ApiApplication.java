package com.zhenghao.risk.control.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * zhenghao
 * 2018/4/4
 */
@SpringBootApplication
@ComponentScan({"com.zhenghao.risk.control.**"})
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
