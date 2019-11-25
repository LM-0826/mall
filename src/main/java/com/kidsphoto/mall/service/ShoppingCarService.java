package com.kidsphoto.mall.service;

import com.alibaba.fastjson.JSONObject;
import com.kidsphoto.mall.entity.ShoppingCar;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-25 14:56
 */
public interface ShoppingCarService {
    void joinCar(JSONObject jsonObject);

    List<ShoppingCar> shoppingCarList(Long userId);

    void delete(Long id);
}
