package cn.wky.cloud.service;

import cn.wky.cloud.entity.Payment;

/**
 * @author wky
 * @create 2020-05-03-10:20
 */
public interface PaymentService {

    int addPayment(Payment payment);

    Payment getPaymentById(Long id);

}
