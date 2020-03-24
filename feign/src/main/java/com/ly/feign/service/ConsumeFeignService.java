package com.ly.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("nacos-discovery-provider")
public interface ConsumeFeignService {

    @RequestMapping(value = "/echo/Linhuantan", method = RequestMethod.GET)
    String echo(@RequestParam(name = "name") String parameter);
}
