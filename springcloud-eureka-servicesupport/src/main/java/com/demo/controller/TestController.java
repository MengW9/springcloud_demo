package com.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud-eureka-server
 * @description:
 * @author: WangMengWei
 * @create: 2020-08-18 11:55
 **/
@RestController
@RequestMapping("/hello")
public class TestController {

    @RequestMapping("/world")
    public String HelloWorld(String s){
        String s1 = String.format("传入的值为：%s", s);
        System.out.println(s1);
        return s1;
    }
}
