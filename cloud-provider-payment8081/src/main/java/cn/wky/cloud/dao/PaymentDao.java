package cn.wky.cloud.dao;

import cn.wky.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wky
 * @create 2020-05-03-9:23
 */
@Mapper
public interface PaymentDao {

    int addPayment(Payment payment);

    Payment getPaymentById(Long id);

}
