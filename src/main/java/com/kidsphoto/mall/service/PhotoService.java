package com.kidsphoto.mall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 李明
 * @create 2019-11-13 13:34
 */
public interface PhotoService {
    void uploadFile(MultipartFile file);
}
