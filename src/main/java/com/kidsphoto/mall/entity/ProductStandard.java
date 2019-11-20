package com.kidsphoto.mall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**商品种类表
 * @author 李明
 * @create 2019-11-08 15:06
 */
@lombok.Data
@Entity
@Table(name = "t_product_standard")
public class ProductStandard extends Data implements Serializable {

    // 产品类型id
    @Column(name = "product_id")
    private Long ProductId;

    // 产品类型 1 单片 2 水晶摆台
    @Column(name = "style")
    private int style;

    // 产品价格
    @Column(name = "price")
    private int price;



}
