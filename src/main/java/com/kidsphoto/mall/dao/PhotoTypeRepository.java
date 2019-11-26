package com.kidsphoto.mall.dao;

import com.kidsphoto.mall.entity.PhotoType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-20 14:35
 */
@Repository
public interface PhotoTypeRepository extends CrudRepository<PhotoType, Long> {

    @Query(value = "SELECT * FROM t_photo_type WHERE row_state = 0 AND school_name = :schoolName", nativeQuery = true)
    List<PhotoType> findBySchoolName(@Param("schoolName") String schoolName);

    @Query(value = "SELECT school_name FROM t_photo_type WHERE row_state = 0 GROUP BY school_name", nativeQuery = true)
    List<String> findSchoolName();

    @Query(value = "SELECT id FROM t_photo_type WHERE row_state = 0 AND type_name = :photoName", nativeQuery = true)
    int findByName(@Param("photoName") String photoName);
}
