package com.kidsphoto.mall.service;

import com.kidsphoto.mall.entity.ProductStandard;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-27 17:26
 */
public interface ProductStandardService {
    void save(ProductStandard productStandard);

    void delete(Long id);

    List<ProductStandard> findList(String name);
}
