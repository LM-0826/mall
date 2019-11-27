package com.kidsphoto.mall.service;

import com.kidsphoto.mall.entity.SchoolPicture;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-27 14:39
 */
public interface SchoolPictureService {
    void save(String schoolName, String pictureUrl);

    void delete(Long id);

    List<SchoolPicture> list();

    List<String> schoolList();

    SchoolPicture findBySchoolName(String schoolName);
}
