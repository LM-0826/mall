package com.kidsphoto.mall.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 李明
 * @create 2019-11-18 16:59
 */
@lombok.Data
@Entity
@Table(name = "t_product")
public class Product extends Data implements Serializable {

    //学校
    @Column(name = "school")
    private String school;

    //产品名字
    @Column(name = "product_name")
    private String productName;

    //照片类型id
    @Column(name = "photo_type_id")
    private Long photoTypeId;

    // 产品描述
    @Column(name = "product_describe")
    private String productDescribe;

    // 价格
    @Column(name = "price")
    private int price;

    // 有无规格 0 无规格，1 有规格
    @Column(name = "flag")
    private int flag;


}
