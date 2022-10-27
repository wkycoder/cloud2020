package cn.wky.cloud.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author wangkunyang
 * @date 2022/10/26 15:28
 */
@Component
public class StockFeignFallback implements FallbackFactory<StockFeignClient> {

    @Override
    public StockFeignClient create(Throwable throwable) {
        return new StockFeignClient() {
            @Override
            public String deduct() {
                return "服务开始降级，异常原因：" + throwable.getMessage();
            }
        };
    }

}
