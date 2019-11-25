package com.kidsphoto.mall.controller;

import com.alibaba.fastjson.JSONObject;
import com.kidsphoto.mall.entity.BusinessException;
import com.kidsphoto.mall.entity.ShoppingCar;
import com.kidsphoto.mall.pojo.ResponseResult;
import com.kidsphoto.mall.service.ShoppingCarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-25 14:18
 */
@RestController
@RequestMapping("/shoppingCar")
@Api(value = "购物车实体操作")
public class ShoppingCarController {

    @Autowired
    private ShoppingCarService shoppingCarService;

    @RequestMapping(value = "/joinCar", method = RequestMethod.POST)
    @ApiOperation(value = "创建购物车实体")
    public ResponseResult joinCar(@RequestBody JSONObject jsonObject) {

        try {
            shoppingCarService.joinCar(jsonObject);
            return ResponseResult.ok();
        } catch (Exception e) {
            if(e instanceof BusinessException) {
                return ResponseResult.fail(e.getMessage());
            }
            return ResponseResult.fail();
        }

    }


    @RequestMapping(value = "/shoppingCarList", method = RequestMethod.GET)
    @ApiOperation(value = "用户购物车下的所有商品")
    public ResponseResult shoppingCarList(@RequestParam("userId") Long userId) {

        try {
            List<ShoppingCar> list = this.shoppingCarService.shoppingCarList(userId);
            return ResponseResult.ok(list);
        } catch (Exception e) {
            if(e instanceof BusinessException) {
                return ResponseResult.fail(e.getMessage());
            }
            return ResponseResult.fail();
        }

    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResponseResult deleteShopping(@RequestParam("id") Long id) {
        try {
            this.shoppingCarService.delete(id);
            return ResponseResult.ok();
        } catch (Exception e) {
            if(e instanceof BusinessException) {
                return ResponseResult.fail(e.getMessage());
            }
            return ResponseResult.fail();
        }
    }


}
