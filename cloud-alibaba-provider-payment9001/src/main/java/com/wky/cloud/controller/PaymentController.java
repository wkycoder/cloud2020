package com.wky.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wky
 * @create 2021-02-22-19:27
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/nacos/{id}")
    public String pay(@PathVariable Integer id) {
        return "nacos registry，id = " + id;
    }
}
