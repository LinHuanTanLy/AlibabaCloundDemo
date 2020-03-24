package com.ly.consumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController()
@RequestMapping("/api/consumer")
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/sayHi")
    public String sayHi() {
        return "sayHi";
//        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-discovery-provider");
//        String url = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(), serviceInstance.getPort(), appName);
//        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/echo/app-name")
    public String echoAppName() {
        //使用 LoadBalanceClient 和 RestTemplate 结合的方式来访问
//        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-discovery-provider");
//        String url = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(), serviceInstance.getPort(), appName);
//        System.out.println("request url:" + url);
        return restTemplate.getForObject("http://nacos-discovery-provider/echo/林焕坍", String.class);
    }
}
