package com.kidsphoto.mall.service;

import java.io.File;

/**
 * @author 李明
 * @create 2019-11-13 13:34
 */
public interface PhotoService {
    String uploadFile(File file, String name);

    void syncData();
}
