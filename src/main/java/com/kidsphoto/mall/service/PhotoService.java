package com.kidsphoto.mall.service;

import com.kidsphoto.mall.entity.Photo;
import com.kidsphoto.mall.entity.ProductS;

import java.io.File;
import java.util.List;

/**
 * @author 李明
 * @create 2019-11-13 13:34
 */
public interface PhotoService {
    String uploadFile(File file, String name);

    void syncData();

    List<Photo> findList(Long userId);

    List<ProductS> findPhotoProducts(Long photoType, Long productId, Long userId);

    List<Photo> findByPhotoTypeId(Long photoTypeId, Long userId);
}
