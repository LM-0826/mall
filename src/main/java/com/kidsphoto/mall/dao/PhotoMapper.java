package com.kidsphoto.mall.dao;

import com.kidsphoto.mall.entity.Photo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-22 10:31
 */
@Mapper
public interface PhotoMapper {

    List<Photo> findByType(Long typeId, Long productId, Long userId);
}
