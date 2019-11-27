package com.kidsphoto.mall.service.impl;

import com.kidsphoto.mall.dao.SchoolPictureRepository;
import com.kidsphoto.mall.entity.SchoolPicture;
import com.kidsphoto.mall.service.SchoolPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-27 14:39
 */
@Service
public class SchoolPictureServiceImpl implements SchoolPictureService {


    @Autowired
    private Environment environment;

    @Autowired
    private SchoolPictureRepository schoolPictureRepository;

    @Override
    @Transactional
    public void save(String schoolName, String pictureUrl) {
        SchoolPicture schoolPicture = new SchoolPicture();
        pictureUrl = this.environment.getProperty("photo.oss.url") + pictureUrl;
        schoolPicture.setPictureUrl(pictureUrl);
        schoolPicture.setSchoolName(schoolName);
        this.schoolPictureRepository.save(schoolPicture);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        schoolPictureRepository.deleteById(id);
    }

    @Override
    public List<SchoolPicture> list() {

        List<SchoolPicture> list = schoolPictureRepository.findList();
        return list;
    }

    @Override
    public List<String> schoolList() {
        List<String> list = schoolPictureRepository.findSchool();
        return list;
    }

    @Override
    public SchoolPicture findBySchoolName(String schoolName) {
        return this.schoolPictureRepository.findBySchoolName(schoolName);
    }
}
