package com.kidsphoto.mall.controller;

import com.kidsphoto.mall.entity.BusinessException;
import com.kidsphoto.mall.entity.ProductStandard;
import com.kidsphoto.mall.pojo.ResponseResult;
import com.kidsphoto.mall.service.ProductStandardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-27 17:04
 */
@RestController
@Api(tags = "商品规格实体操作")
@RequestMapping("/productStandard")
public class ProductStandardController {

    @Autowired
    private ProductStandardService productStandardService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "创建和修改产品规格")
    public ResponseResult save(@RequestBody ProductStandard productStandard) {

        try {
            productStandardService.save(productStandard);
            return ResponseResult.ok();
        } catch (Exception e) {
            if(e instanceof BusinessException) {
                return ResponseResult.fail(e.getMessage());
            }
            return ResponseResult.fail();
        }
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ApiOperation(value = "删除产品规格")
    public ResponseResult delete(@RequestParam("id") Long id) {

        try {
            productStandardService.delete(id);
            return ResponseResult.ok();
        } catch (Exception e) {
            if(e instanceof BusinessException) {
                return ResponseResult.fail(e.getMessage());
            }
            return ResponseResult.fail();
        }
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation(value = "产品规格列表")
    public ResponseResult list(@RequestParam("schoolName") String name) {

        List<ProductStandard> list = productStandardService.findList(name);
        return ResponseResult.ok(list);

    }


}
