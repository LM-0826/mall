package com.kidsphoto.mall.service.impl;

import com.kidsphoto.mall.dao.PhotoTypeRepository;
import com.kidsphoto.mall.entity.PhotoType;
import com.kidsphoto.mall.service.PhotoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-20 14:39
 */
@Service
public class PhotoTypeServiceImpl implements PhotoTypeService {

    @Autowired
    private PhotoTypeRepository photoTypeRepository;

    @Override
    @Transactional
    public void save(String photoTypeName, String schoolName) {

        PhotoType photoType = new PhotoType();
        photoType.setTypeName(photoTypeName);
        photoType.setSchoolName(schoolName);
        this.photoTypeRepository.save(photoType);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        this.photoTypeRepository.deleteById(id);
    }

    @Override
    public List<PhotoType> findBySchoolName(String schoolName) {

        List<PhotoType> list = this.photoTypeRepository.findBySchoolName(schoolName);
        return list;
    }

    @Override
    public List<String> findSchoolName() {
        List<String> list = this.photoTypeRepository.findSchoolName();
        return list;
    }


}
