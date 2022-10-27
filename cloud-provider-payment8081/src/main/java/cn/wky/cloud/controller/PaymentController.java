package cn.wky.cloud.controller;

import cn.wky.cloud.entity.CommonResult;
import cn.wky.cloud.entity.Payment;
import cn.wky.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author wky
 * @create 2020-05-03-10:25
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult addPayment(@RequestBody Payment payment) { // 这里使用@RequestBody注解作用是接收前端发送的post请求
        int result = paymentService.addPayment(payment);           // 的请求体中的json串中的数据封装到该方法的payment参数中
        log.info("*****插入结果" + result);

        if (result > 0 ) { // 插入成功
            return new CommonResult(200, "插入成功", result);
        } else {
            return new CommonResult(444, "插入失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果" + payment);

        if (payment != null) { // 查询成功
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "查询失败，id="+id, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() { // 获取Eureka服务器上的所有服务的信息及每个服务的所有实例的信息
        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            log.info("*******service：" + service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info("*******instance：" + instance.getHost() + "\t" + instance.getPort());
            }
        }

        return this.discoveryClient;

    }
}
