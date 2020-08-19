package com.demo.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloud-eureka-server
 * @description:
 * @author: WangMengWei
 * @create: 2020-08-18 17:55
 **/
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/hello")
public class ConsumerController {

    private LoadBalancerClient loadBalancerClient;
    private RestTemplate restTemplate;

    public ConsumerController(LoadBalancerClient loadBalancerClient, RestTemplate restTemplate) {
        this.loadBalancerClient = loadBalancerClient;
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/consumer")
    public String HelloWorld(String s) {
        System.out.println("传入consumer的值是：" + s);
        String forObject = restTemplate.getForObject("http://EUREKA-SERVICE/hello/world?s=" + s, String.class);
        return forObject;
    }

}
