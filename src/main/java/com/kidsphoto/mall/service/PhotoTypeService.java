package com.kidsphoto.mall.service;

import com.kidsphoto.mall.entity.PhotoType;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-20 14:38
 */
public interface PhotoTypeService {
    void save(String photoTypeName, String schoolName);

    void delete(Long id);

    List<PhotoType> findBySchoolName(String schoolName);

    List<String> findSchoolName();
}
