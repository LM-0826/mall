package com.kidsphoto.mall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 李明
 * @create 2019-11-08 14:50
 */
@Entity
@lombok.Data
@Table(name = "t_order")
public class Order extends Data implements Serializable {

    // 金额
    @Column(name = "price",  nullable = false)
    private BigDecimal price = new BigDecimal("0.00");

    // 订单号
    @Column(name = "order_no")
    private String orderNo;

    // 支付状态 0:待支付 1:支付完成
    @Column(name = "state")
    private int state;

    // 支付渠道类型. 1001:公众号微信支付 1002：H5微信支付 1002：H5支付宝支付
    @Column(columnDefinition = "INT default 0")
    private int payChannel;

    // 用户id
    @Column(name = "user_id")
    private Long userId;






}
