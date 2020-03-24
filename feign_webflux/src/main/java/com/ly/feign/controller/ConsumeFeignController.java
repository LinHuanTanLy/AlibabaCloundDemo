package com.ly.feign.controller;

import com.ly.feign.service.ConsumeFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/feign/consume")
public class ConsumeFeignController {


    @Autowired
    ConsumeFeignService service;

    @Autowired
    WebClient.Builder builder;

    @GetMapping("/echo/app-name")
    public String consumeController(String name) {
        return service.echo(name);
    }

    @GetMapping("/echo/app-name/webClient")
    public Mono<String> consumeControllerWebClient(String name) {
        return builder.build()
                .get()
                .uri("http://nacos-discovery-provider/echo/LinhuantanWebClient")
                .retrieve()
                .bodyToMono(String.class);
    }
}
