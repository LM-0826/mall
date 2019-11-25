package com.kidsphoto.mall.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kidsphoto.mall.dao.ShoppingCarRepository;
import com.kidsphoto.mall.entity.ShoppingCar;
import com.kidsphoto.mall.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-25 14:56
 */
@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {

    @Autowired
    private ShoppingCarRepository shoppingCarRepository;

    @Override
    public void joinCar(JSONObject jsonObject) {

        String param = jsonObject.getString("param");
        JSONArray list = JSONObject.parseArray(param);

        for(int i = 0; i < list.size(); i++) {
            Integer bookNumber = list.getJSONObject(i).getInteger("bookNumber");
            String bookName = list.getJSONObject(i).getString("bookName");
            Integer type = list.getJSONObject(i).getInteger("type");
            String imageUrl = list.getJSONObject(i).getString("imageUrl");
            Integer price = list.getJSONObject(i).getInteger("price");
            Long userId = list.getJSONObject(i).getLong("userId");

            ShoppingCar shoppingCar = new ShoppingCar();
            shoppingCar.setBookNumber(bookNumber);
            shoppingCar.setBookName(bookName);
            shoppingCar.setType(type);
            shoppingCar.setImageUrl(imageUrl);
            shoppingCar.setPrice(price);
            this.shoppingCarRepository.save(shoppingCar);
        }
            
        }

    @Override
    public List<ShoppingCar> shoppingCarList(Long userId) {
        List<ShoppingCar> list = this.shoppingCarRepository.findByUserId(userId);
        return list;
    }

    @Override
    public void delete(Long id) {
        this.shoppingCarRepository.deleteShopping(id);
    }

}
