package com.kidsphoto.mall.dao;

import com.kidsphoto.mall.entity.ProductS;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-22 10:31
 */
public interface PhotoMapper {

    List<ProductS> findByType(Long typeId, Long productId, Long userId);
}
