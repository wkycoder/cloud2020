package cn.wky.cloud.controller;

import cn.wky.cloud.entity.CommonResult;
import cn.wky.cloud.entity.Payment;
import cn.wky.cloud.feign.PaymentFeignClient;
import com.fasterxml.jackson.core.JsonToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wky
 * @create 2020-05-03-12:37
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://cloud-payment-service"; // 未使用Ribbon之前："http://localhost:8081"

    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private PaymentFeignClient paymentFeignClient;

    @PostMapping("/consumer/payment/pay")
    public CommonResult pay() {
        String data = paymentFeignClient.pay();
        System.out.println(data);
        return CommonResult.ok("请求成功", data);

    }

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);

    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        return result;
    }
}
