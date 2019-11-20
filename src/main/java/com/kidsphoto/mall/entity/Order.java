package com.kidsphoto.mall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 李明
 * @create 2019-11-08 14:50
 */
@Entity
@lombok.Data
@Table(name = "t_order")
public class Order extends Data implements Serializable {

    // 金额
    @Column(name = "price")
    private String price;

    // 订单号
    @Column(name = "order_no")
    private String orderNo;

    // 支付状态 0:待支付 1:支付完成 2:支付中
    @Column(name = "state")
    private int state;

    // 支付渠道类型.支付宝app支付：1011; 支付宝网页支付：1003; 微信app支付：1002; 微信公众号支付:1004
    @Column(columnDefinition = "INT default 0")
    private int payChannel;

    // 用户id
    @Column(name = "user_id")
    private Long userId;






}
