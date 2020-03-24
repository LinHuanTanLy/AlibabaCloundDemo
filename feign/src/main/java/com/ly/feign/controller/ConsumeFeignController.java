package com.ly.feign.controller;

import com.ly.feign.service.ConsumeFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feign/consume")
public class ConsumeFeignController {


    @Autowired
    ConsumeFeignService service;

    @GetMapping("/echo/app-name")
    public String consumeController( String name) {
        return service.echo(name);
    }
}
