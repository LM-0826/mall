package com.kidsphoto.mall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 李明
 * @create 2019-11-20 13:28
 */
@Entity
@lombok.Data
@Table(name = "t_shopping_car")
public class ShoppingCar extends Data implements Serializable {

    // 照片id
    @Column(name = "photo_id")
    private Long photoId;

    // 产品规格id
    @Column(name = "product_standard_id")
    private Long productStandardId;

    // 订购数量
    @Column(name = "number")
    private int number;

    // 产品名字
    @Column(name = "name")
    private String name;

    // 规格 1 单片 2 摆台
    @Column(name = "type")
    private int type;

    // 单价
    @Column(name = "price")
    private int price;

    // 总价
    @Column(name = "total_price")
    private int totalPrice;

}
