package cn.wky.cloud.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author wangkunyang
 * @date 2022/10/26 15:28
 */
@Component
public class PaymentFeignFallback implements FallbackFactory<PaymentFeignClient> {


    @Override
    public PaymentFeignClient create(Throwable throwable) {
        return new PaymentFeignClient() {
            @Override
            public String pay() {
                return "服务开始降级，异常原因：" + throwable.getMessage();
            }
        };
    }

}
