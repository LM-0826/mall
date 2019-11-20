package com.kidsphoto.mall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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

    //1 套餐商品 2 产品
    @Column(name = "product_type")
    private int productType;

    //产品名字
    @Column(name = "product_name")
    private String productName;

    //照片类型id
    @Column(name = "photo_type_id")
    private Long photoTypeId;

    // 套餐产品中包含产品的id
    @Column(name = "ids")
    private String ids;

    // 产品描述
    @Column(name = "product_describe")
    private String productDescribe;



}
