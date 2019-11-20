package com.kidsphoto.mall.entity;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @author 李明
 * @create 2019-11-18 16:59
 */
public class Product extends Data implements Serializable {

    //学校
    @Column(name = "school")
    private String school;

    //1 套餐商品 2 产品
    @Column(name = "type")
    private int type;

    //产品名字
    @Column(name = "name")
    private String name;

    //照片类型id
    @Column(name = "photo_type_id")
    private Long photoTypeId;

    // 套餐产品中包含产品的id
    @Column(name = "ids")
    private String ids;

    // 产品描述
    @Column(name = "describe")
    private String describe;



}
