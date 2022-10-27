package cn.wky.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author wangkunyang
 * @date 2022/10/26 15:24
 */
@FeignClient(name = "cloud-payment", fallbackFactory = PaymentFeignFallback.class)
public interface PaymentFeignClient {

    @PostMapping("/pay")
    String pay();

}
