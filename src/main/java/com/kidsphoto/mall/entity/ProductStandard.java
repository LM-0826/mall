package com.kidsphoto.mall.entity;

import java.io.Serializable;

/**商品种类表
 * @author 李明
 * @create 2019-11-08 15:06
 */
//@lombok.Data
//@Entity
//@Table(name = "t_product_standard")
public class ProductStandard extends Data implements Serializable {

    // 产品规格
//    @Column(name = "style_name")
    private int styleName;

}
