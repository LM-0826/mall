package com.kidsphoto.mall.service;

import com.kidsphoto.mall.entity.Product;

import java.util.List;
import java.util.Map;

/**
 * @author 李明
 * @create 2019-11-21 9:01
 */
public interface ProductService {
    void save(Product product);

    Product findDetail(Long productId);

    void delete(Long productId);

    List<Product> findList(String school, int offset, int size);

    Map<String, Object> goodsList(String school);
}
