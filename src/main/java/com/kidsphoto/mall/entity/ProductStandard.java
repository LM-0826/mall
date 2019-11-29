package com.kidsphoto.mall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**商品种类表
 * @author 李明
 * @create 2019-11-08 15:06
 */
@lombok.Data
@Entity
@Table(name = "t_product_standard")
public class ProductStandard extends Data implements Serializable {

    // 商品id
    @Column(name = "product_id")
    private Long productId;

    // 照片类型id
    @Column(name = "photo_type_id")
    private Long photoTypeId;

    // 学校
    @Column(name = "school")
    private String school;

    // 产品类型  单品，  套餐A，套餐B
    @Column(name = "product_type")
    private String productType;

    // 产品名字
    @Column(name = "product_name")
    private String productName;

    // 规格1单片，2摆台
    @Column(name = "product_standard")
    private int productStandard;

    // 价格
    @Column(name = "price",  nullable = false)
    private BigDecimal price = new BigDecimal("0.00");

    // 规格描述
    @Column(name = "standard_descreibe")
    private String standardDescribe;



}
