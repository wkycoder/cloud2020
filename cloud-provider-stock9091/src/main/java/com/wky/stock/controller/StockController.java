package com.wky.stock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author wky
 * @create 2020-11-04-17:09
 */
@RestController
public class StockController {

    @PostMapping("/stock/deduct")
    public String deduct() throws InterruptedException {
        // 阻塞，模拟请求超时
        TimeUnit.SECONDS.sleep(5);
        return "扣减成功";
    }

}
