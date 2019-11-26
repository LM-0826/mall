package com.kidsphoto.mall.entity;

import org.springframework.stereotype.Component;

/**
 * @author 李明
 * @create 2019-11-22 19:08
 */
@lombok.Data
@Component
public class ps {

    public Long id;

    public int price;

    public String productName;

    public String school;

    public String standardDescreibe;
}
