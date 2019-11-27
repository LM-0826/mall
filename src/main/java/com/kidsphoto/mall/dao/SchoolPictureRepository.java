package com.kidsphoto.mall.dao;

import com.kidsphoto.mall.entity.SchoolPicture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-27 14:38
 */
@Repository
public interface SchoolPictureRepository extends CrudRepository<SchoolPicture, Long> {

    @Query(value = "SELECT * FROM t_school_picture ", nativeQuery = true)
    List<SchoolPicture> findList();

    @Query(value = "SELECT school_name FROM t_school_picture", nativeQuery = true)
    List<String> findSchool();

    @Query(value = "SELECT * FROM t_school_picture WHERE school_name = :schoolName ", nativeQuery = true)
    SchoolPicture findBySchoolName(String schoolName);
}
