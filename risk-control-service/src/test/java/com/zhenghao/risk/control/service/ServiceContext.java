package com.zhenghao.risk.control.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * zhenghao
 * 2018/4/4
 */
@Configuration
@ComponentScan({"com.zhenghao.risk.control.**"})
@EnableAspectJAutoProxy
public class ServiceContext {

}
