package com.kidsphoto.mall.service;

import com.kidsphoto.mall.entity.Photo;

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

    List<Photo> findPhotoProducts(Long photoType, Long productId, Long userId);
}
