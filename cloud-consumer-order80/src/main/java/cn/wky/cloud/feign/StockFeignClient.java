package cn.wky.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author wangkunyang
 * @date 2022/10/27 14:10
 */
@FeignClient(name = "cloud-stock", fallbackFactory = StockFeignFallback.class)
public interface StockFeignClient {


    @PostMapping("/stock/deduct")
    String deduct();


}
