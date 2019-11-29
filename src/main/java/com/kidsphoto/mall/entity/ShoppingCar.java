package com.kidsphoto.mall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 李明
 * @create 2019-11-20 13:28
 */
@Entity
@lombok.Data
@Table(name = "t_shopping_car")
public class ShoppingCar extends Data implements Serializable {

    // 订购数量
    @Column(name = "book_number")
    private int bookNumber;

    // 产品名字
    @Column(name = "book_name")
    private String bookName;

    // 规格 0 无规格 1 单片 2 摆台
    @Column(name = "type")
    private int type;

    // 价格
    @Column(name = "price",  nullable = false)
    private BigDecimal price = new BigDecimal("0.00");

    // 图片路径
    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "user_id")
    private Long userId;

    // 是否支付过 0 未支付过 1 支付过
    @Column(name = "state")
    private int state;

    // 产品id
    @Column(name = "product_id")
    private Long productId;

    // 产品规格ID
    @Column(name = "product_standard_id")
    private Long productStandardId;


}
