package com.kidsphoto.mall.entity;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-22 19:06
 */
@lombok.Data
@Component
public class ProductS {

    public String imgUrl;

    public Long userId;

    public List<ps> list;
}
