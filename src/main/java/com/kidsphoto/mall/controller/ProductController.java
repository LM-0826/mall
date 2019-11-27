package com.kidsphoto.mall.controller;

import com.kidsphoto.mall.entity.BusinessException;
import com.kidsphoto.mall.entity.Product;
import com.kidsphoto.mall.pojo.ResponseResult;
import com.kidsphoto.mall.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 李明
 * @create 2019-11-21 8:56
 */
@RestController
@RequestMapping("/product")
@Api(tags = "产品实体操作")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "创建或修改产品")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseResult save(@RequestBody Product product) {

        try {
            this.productService.save(product);
            return ResponseResult.ok();
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                return ResponseResult.fail(e.getMessage());
            }
            return ResponseResult.fail();
        }
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ApiOperation(value = "查询产品详情")
    public ResponseResult detail(@RequestParam("productId") Long productId) {

        try {
            Product product = this.productService.findDetail(productId);
            return ResponseResult.ok(product);
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                return ResponseResult.fail(e.getMessage());
            }
            return ResponseResult.fail();
        }

    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ApiOperation(value = "删除商品")
    public ResponseResult delete(@RequestParam("productId") Long productId) {

        try {
            this.productService.delete(productId);
            return ResponseResult.ok();
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                return ResponseResult.fail(e.getMessage());
            }
            return ResponseResult.fail();
        }

    }

    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    @ApiOperation(value = "查询某学校下的列表")
    public ResponseResult queryList(@RequestParam("school") String school, @RequestParam("page") int page, @RequestParam("size") int size) {

        int offset = (page - 1)*size;
        try {
            Map<String, Object> map = this.productService.findList(school, offset, size);
            return ResponseResult.ok(map);
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                return ResponseResult.fail(e.getMessage());
            }
            return ResponseResult.fail();
        }
    }

    @RequestMapping(value = "/goodsList", method = RequestMethod.GET)
    @ApiOperation(value = "用户看到的商品列表")
    public ResponseResult goodsList(@RequestParam("school") String school) {
        Map<String, Object> map = productService.goodsList(school);
        return ResponseResult.ok(map);
    }


    @RequestMapping(value = "/photoProductStandard", method = RequestMethod.GET)
    @ApiOperation(value = "某学校下需要增加规格的产品")
    public ResponseResult photoProductStandard(@RequestParam("schoolName") String schoolName) {

        List<Product> list = productService.findHaveStandard(schoolName);
        return ResponseResult.ok(list);
    }



}
