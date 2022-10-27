package cn.wky.cloud.controller;

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
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String say() {
        return serverPort;
    }

    @PostMapping("/pay")
    public String pay() throws InterruptedException {
        Random random = new Random();
        int i = random.nextInt();
        System.out.println(i);
        if (i % 2 == 0) {
            // 阻塞，模拟请求超时
            TimeUnit.SECONDS.sleep(5);
        }
        return "支付成功";
    }




}
